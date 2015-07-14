package com.cloud.jem.counter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Jem on 14-07-2015.
 */
public class Menu extends ListActivity {

    String[] classes = {"FirstActivity", "MainActivity", "Menu"};

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String cheesee = classes[position];

        try
        {
            Class ourClass = Class.forName("com.cloud.jem.counter." + cheese);
            Intent ourIntent = new Intent(Menu.this, ourClass);

            startActivity(ourIntent);
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
    }
}
