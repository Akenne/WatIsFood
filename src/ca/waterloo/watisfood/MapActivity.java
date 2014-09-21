
package ca.waterloo.watisfood;

import android.app.Activity;
import android.content.Intent;
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

    boolean open = false;

    RestAdapter restAdapter;
    DataInterface dataInterface;

    TouchImageView map = null;
    Bitmap bmp = null;
    Bitmap markerBitmap = null;
    Canvas canvas = null;
    OutletData data = null;
    LinearLayout ll;


    public static final String API_URL = "https://api.uwaterloo.ca/";

    private static long mDeBounce = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity_layout);


        Bundle b = this.getIntent().getExtras();

        open = b.getBoolean("seeOpen");
        Log.d("WF", "Open is " + open);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setConverter(new SimpleXMLConverter())
                .build();

        // Create an instance of our SiteData API interface.
        dataInterface = restAdapter.create(DataInterface.class);

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

                if ( Math.abs(mDeBounce  - event.getEventTime()) < 250) {
                    //Ignore if it's been less then 250ms since
                    //the item was last clicked
                    return true;
                }

                int intCurrentY = Math.round(event.getY());
                int intCurrentX = Math.round(event.getX());
                int intStartY = event.getHistorySize() > 0 ? Math.round(event.getHistoricalY(0)) : intCurrentY;
                int intStartX = event.getHistorySize() > 0 ? Math.round(event.getHistoricalX(0)) : intCurrentX;

                if ( (event.getAction() == MotionEvent.ACTION_UP) && (Math.abs(intCurrentX - intStartX) < 3) && (Math.abs(intCurrentY - intStartY) < 3) ) {
                    if ( 0 > event.getDownTime() ) {
                        //Still got occasional duplicates without this
                        return true;
                    }

                    // handle the click

                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    int width = size.x;
                    int height = size.y;

                    float curX = (float)(2330 * map.getScrollPosition().x + (event.getX() * Math.pow(map.getCurrentZoom(), -1) - (width/2)));
                    float curY = (float)(1718 * map.getScrollPosition().y + (event.getY()) - (height/2)+60);//voodoo magic do not touch


                    for(int i = 0; i < BuildingLocation.coords.length; i++) {
                        if(((BuildingLocation.coords[i][0] > curX- 50) && (BuildingLocation.coords[i][0] < curX+ 50)) &&
                                ((BuildingLocation.coords[i][1] > curY- 50) && (BuildingLocation.coords[i][1] < curY+ 50))){
                            Log.d("WF", curX+" "+curY+"");
                            //BuildingLocation.buildingCodes[i]
                            int count = 0;
                            OutletData.Item store = null;
                            for (OutletData.Item item : data.getData()) {
                                Log.d("WF", (item.getBuilding())+" "+(BuildingLocation.buildingCodes[i])+"");
                                if (String.valueOf(item.getBuilding()).equals(BuildingLocation.buildingCodes[i])) {
                                    if (!open || (open && item.getIs_open_now() != null)) {

                                        count++;
                                        store = item;

                                        Intent shop = new Intent(getBaseContext(), ShopInfoActivity.class);
                                        Bundle mBundle = new Bundle();
                                        mBundle.putString("title", store.getOutlet_name());
                                        mBundle.putString("isOpen", store.getIs_open_now());
                                        mBundle.putString("description", store.getDescription());
                                        mBundle.putString("building", store.getBuilding());
                                        String[] times = new String[7];

                                        times[0] = store.getOpening_hours().getMonday().getOpening_hour() + "-" + store.getOpening_hours().getMonday().getClosing_hour();
                                        times[1] = store.getOpening_hours().getTuesday().getOpening_hour() + "-" + store.getOpening_hours().getTuesday().getClosing_hour();
                                        times[2] = store.getOpening_hours().getWednesday().getOpening_hour() + "-" + store.getOpening_hours().getWednesday().getClosing_hour();
                                        times[3] = store.getOpening_hours().getThursday().getOpening_hour() + "-" + store.getOpening_hours().getThursday().getClosing_hour();
                                        times[4] = store.getOpening_hours().getFriday().getOpening_hour() + "-" + store.getOpening_hours().getFriday().getClosing_hour();
                                        times[5] = store.getOpening_hours().getSaturday().getOpening_hour() + "-" + store.getOpening_hours().getSaturday().getClosing_hour();
                                        times[6] = store.getOpening_hours().getSunday().getOpening_hour() + "-" + store.getOpening_hours().getSunday().getClosing_hour();

                                        mBundle.putStringArray("times", times);
                                        shop.putExtras(mBundle);
                                        startActivity(shop);
                                    }
                                }
                            }

                            break;
                        }
                    }

                    mDeBounce  = event.getEventTime();
                    return true;
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
                        if (item.getIs_open_now() != null || !open){
                            applicableBuildings.add(item.getBuilding());
                            int[] coord = bLoc.locate(String.valueOf(item.getBuilding()));
                            canvas.drawBitmap(markerBitmap, coord[0] - 17, coord[1] - 47, null);
                        }
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
