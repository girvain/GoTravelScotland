package com.example.gavinross.gotravelscotland;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.custom_array_adapter_content.BasicItem;
import com.example.gavinross.gotravelscotland.custom_array_adapter_content.ListItemArrayAdapter;

import java.util.ArrayList;

/**
 * Created by gavin on 18/03/18.
 */

public class WhatsOn extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_adapter_page);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        TextView headingOne = (TextView) findViewById(R.id.heading_one);
        headingOne.setText(R.string.whatson_page_title);
        TextView headingTwo = (TextView) findViewById(R.id.heading_two);
        headingTwo.setText(R.string.whatson_page_para);

        ArrayList<BasicItem> basicItems = new ArrayList<BasicItem>();
        basicItems.add(new BasicItem(R.drawable.dragon, R.string.childrens_page_item_name,  R.string.childrens_page_list_item_text));
        basicItems.add(new BasicItem(R.drawable.dragon, R.string.childrens_page_item_name,  R.string.childrens_page_list_item_text));
        basicItems.add(new BasicItem(R.drawable.dragon, R.string.childrens_page_item_name,  R.string.childrens_page_list_item_text));
        basicItems.add(new BasicItem(R.drawable.dragon, R.string.childrens_page_item_name,  R.string.childrens_page_list_item_text));
        basicItems.add(new BasicItem(R.drawable.dragon, R.string.childrens_page_item_name,  R.string.childrens_page_list_item_text));


        ListItemArrayAdapter adapter = new ListItemArrayAdapter(this, basicItems);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }

}
