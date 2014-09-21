package ca.waterloo.watisfood;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Kevin on 21/09/2014.
 */
public class ShopListActivity extends Activity {

    ListView list = (ListView)findViewById(R.id.buttonOpen);

    @Override
    public void onCreate(Bundle savedInstanceState) {

        String[] items = new String[] {};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        adapter.add("ASDF");
        adapter.add("ASDF");

        list.setAdapter(adapter);

    }
}
