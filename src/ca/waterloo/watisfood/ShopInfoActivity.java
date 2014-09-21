package ca.waterloo.watisfood;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Kevin on 21/09/2014.
 */
public class ShopInfoActivity extends Activity {

    TextView title;
    TextView isOpen;
    TextView description;
    TextView[] times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_info_layout);

        title = (TextView) findViewById(R.id.title);
        isOpen = (TextView) findViewById(R.id.is_open);
        description = (TextView) findViewById(R.id.description);
        times = new TextView[7];

        times[0] = (TextView) findViewById(R.id.time1);
        times[2] = (TextView) findViewById(R.id.time2);
        times[3] = (TextView) findViewById(R.id.time3);
        times[4] = (TextView) findViewById(R.id.time4);
        times[5] = (TextView) findViewById(R.id.time5);
        times[6] = (TextView) findViewById(R.id.time6);
        times[7] = (TextView) findViewById(R.id.time7);

        Bundle b=this.getIntent().getExtras();

        String[] time = b.getStringArray("times");

        title.setText(b.getString("title"));
        isOpen.setText(b.getString("isOpen"));
        description.setText(b.getString("description"));

        for (int i = 0; i < 7; i++) {
            times[i].setText(time[i]);
        }
    }
}
