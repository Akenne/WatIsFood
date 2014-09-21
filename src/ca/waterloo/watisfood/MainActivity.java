package ca.waterloo.watisfood;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buttonOpen = (Button)findViewById(R.id.buttonOpen);
        buttonOpen.setOnClickListener(openListener); // Register the onClick listener with the implementation above

        Button buttonAll = (Button)findViewById(R.id.buttonAll);
        buttonAll.setOnClickListener(allListener); // Register the onClick listener with the implementation above
    }

    //Create an anonymous implementation of OnClickListener
    private OnClickListener openListener = new OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), MapActivity.class);

            Bundle mBundle = new Bundle();
            mBundle.putBoolean("seeOpen", true);
            
            i.putExtras(mBundle);
            startActivity(i);
        }
    };

    // Create an anonymous implementation of OnClickListener
    private OnClickListener allListener = new OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), MapActivity.class);

            Bundle mBundle = new Bundle();
            mBundle.putBoolean("seeOpen", false);

            i.putExtras(mBundle);
            startActivity(i);
        }
    };
}
