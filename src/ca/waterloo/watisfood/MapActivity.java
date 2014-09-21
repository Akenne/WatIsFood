
package ca.waterloo.watisfood;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.SimpleXMLConverter;
import android.widget.LinearLayout;
import java.util.HashSet;
import java.util.Set;

public class MapActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    RestAdapter restAdapter;
    DataInterface dataInterface;

    TouchImageView map = null;
    Bitmap bmp = null;
    Bitmap markerBitmap = null;
    Canvas canvas = null;
    OutletData data = null;
    LinearLayout ll;


    public static final String API_URL = "https://api.uwaterloo.ca/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Boolean yourBool = getIntent().getExtras().getBoolean("Done");
        setContentView(R.layout.map_activity_layout);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setConverter(new SimpleXMLConverter())
                .build();

        // Create an instance of our SiteData API interface.
        dataInterface = restAdapter.create(DataInterface.class);

        ll = (LinearLayout) findViewById(R.id.slider);
        ll.setVisibility(View.GONE);

        map = (TouchImageView)findViewById(R.id.map);
        map.setMaxZoom(1);
        map.setMinZoom(1);

        // Init our overlay bitmap

        // Map bitmap
        Bitmap mapBitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.map_colour);

        // Marker bitmap
        markerBitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.map_marker);

        bmp = mapBitmap.copy(Bitmap.Config.ARGB_8888, true);
        // Init the canvas
        canvas = new Canvas(bmp);
        // Draw the text on top of the canvas

        requestSiteData();

        /*
        BuildingLocation bLoc = new BuildingLocation();
        int[] coord = bLoc.locate("DC");

        canvas.drawBitmap(markerBitmap, coord[0] - 17, coord[1] - 47, null);
*/

        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;

                float curX = (float)(2330 * map.getScrollPosition().x + (event.getX() * Math.pow(map.getCurrentZoom(), -1) - (width/2)));
                float curY = (float)(1718 * map.getScrollPosition().y + (event.getY()) - (height/2)+60);//voodoo magic do not touch


                //mCanvas.drawCircle(((curX / scale)), ((curY / scale)),
                //        width / 2 / scale, mPaint);

                for(int i = 0; i < BuildingLocation.coords.length; i++) {
                    if(((BuildingLocation.coords[i][0] > curX- 50) && (BuildingLocation.coords[i][0] < curX+ 50)) &&
                            ((BuildingLocation.coords[i][1] > curY- 50) && (BuildingLocation.coords[i][1] < curY+ 50))){
                        Log.d("WF", curX+" "+curY+"");
                        //BuildingLocation.buildingCodes[i]
                        int count = 0;
                        for (OutletData.Item item : data.getData()) {
                            if (item.getBuilding().equals(BuildingLocation.buildingCodes[i])){
                                count++;
                                if (count>1){
                                    ll.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                        //go to list screen
                    }
                }
                return false;
            }
        });
    }

    private void requestSiteData() {
        dataInterface.report(new Callback<OutletData>() {
            @Override
            public void success(OutletData siteData, retrofit.client.Response response) {

                data = siteData;

                BuildingLocation bLoc = new BuildingLocation();

                Set<String> applicableBuildings = new HashSet<String>();

                for (OutletData.Item item : siteData.getData()) {
                        applicableBuildings.add(item.getBuilding());
                        int[] coord = bLoc.locate(String.valueOf(item.getBuilding()));
                        canvas.drawBitmap(markerBitmap, coord[0] - 17, coord[1] - 47, null);
                }

                Log.d("WF", map + " is the map value");
                map.setImageBitmap(bmp);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("WF", retrofitError.getMessage());
                Log.d("WF", retrofitError.getUrl());
            }
        });
    }
}
