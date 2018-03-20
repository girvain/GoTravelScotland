package com.example.gavinross.gotravelscotland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gavinross.gotravelscotland.custom_array_adapter_content.BasicItem;
import com.example.gavinross.gotravelscotland.custom_array_adapter_content.ListItemArrayAdapter;
import com.example.gavinross.gotravelscotland.viewpager_content.FragContainer;

import java.util.ArrayList;

/**
 * Created by gavin on 19/03/18.
 */

public class Children extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_adapter_page);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        Toast.makeText(getApplicationContext(),"Select an option", Toast.LENGTH_SHORT).show();

        TextView headingOne = (TextView) findViewById(R.id.heading_one);
        headingOne.setText(R.string.children_page_title);
        TextView headingTwo = (TextView) findViewById(R.id.heading_two);
        headingTwo.setText(R.string.children_page_para);

        ArrayList<BasicItem> basicItems = new ArrayList<BasicItem>();
        basicItems.add(new BasicItem(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!", true));
        basicItems.add(new BasicItem(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));
        basicItems.add(new BasicItem(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));
        basicItems.add(new BasicItem(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));
        basicItems.add(new BasicItem(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));

        final ListItemArrayAdapter adapter = new ListItemArrayAdapter(this, basicItems);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        /*
        Listener for each item in the arrayAdapter list. Checks to see if the object is intended
        to launch an activity.

        NOTE: This needs to be updated when there is more options for the childrens section. If
                the BasicItem class is indexed with numbers on what type of object to create i.e
                fragmentContainer, then it can call a method like getType that will return the
                number index and create the next Activity with a collection of if (getType == 2) etc
                then create new Intent(something... .class) etc.

         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                if (adapter.getItem(position).hasActivity()) {
                    Intent i = new Intent(Children.this, FragContainer.class);
                    i.putExtra("adapterTourOption", 4);
                    startActivity(i);
                }
            }
        });
    }

}
