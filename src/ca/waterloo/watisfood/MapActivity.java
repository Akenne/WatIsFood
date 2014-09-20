
package ca.waterloo.watisfood;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.SimpleXMLConverter;

public class MapActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    RestAdapter restAdapter;
    DataInterface dataInterface;

    public static final String API_URL = "https://api.uwaterloo.ca/v2/foodservices/locations.xml?key=f41a069b66774984b6e9d1c406432122";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Boolean yourBool = getIntent().getExtras().getBoolean("Done");
        setContentView(R.layout.map_activity_layout);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(OutletData.API_URL)
                .setConverter(new SimpleXMLConverter())
                .build();

        // Create an instance of our SiteData API interface.
        dataInterface = restAdapter.create(DataInterface.class);

        requestSiteData();

        final TouchImageView map = (TouchImageView)findViewById(R.id.map);
        map.setMaxZoom(2);
        map.setMinZoom((float)0.5);

        // Init our overlay bitmap

        // Map bitmap
        Bitmap mapBitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.map_colour);

        // Overlay bitmap
        Bitmap mapBitmapOverlay = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.map_colour_overlay);

        // Marker bitmap
        Bitmap markerBitmap = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.map_marker);

        Bitmap bmp = mapBitmap.copy(Bitmap.Config.ARGB_8888, true);
        // Init the canvas
        Canvas canvas = new Canvas(bmp);
        // Draw the text on top of the canvas

        BuildingLocation bLoc = new BuildingLocation();
        int[] coord = bLoc.locate("DC");

        canvas.drawBitmap(markerBitmap, coord[0] - 17, coord[1] - 47, null);

        map.setImageBitmap(bmp);

        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;

                float curX = (float)(2330 * map.getScrollPosition().x + (event.getX() * Math.pow(map.getCurrentZoom(), -1) - (width/2)));
                float curY = (float)(1718 * map.getScrollPosition().y + (event.getY() * Math.pow(map.getCurrentZoom(), -1) - (height/2)));

                //mCanvas.drawCircle(((curX / scale)), ((curY / scale)),
                //        width / 2 / scale, mPaint);
                return false;
            }
        });
    }

    private void requestSiteData() {
        dataInterface.report(new Callback<OutletData>() {
            @Override
            public void success(OutletData siteData, retrofit.client.Response response) {
                Log.d("WF", "SUCCESS");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });
    }
}
