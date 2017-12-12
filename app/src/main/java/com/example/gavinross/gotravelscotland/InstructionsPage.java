package com.example.gavinross.gotravelscotland;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by gavinross on 12/12/2017.
 */

public class InstructionsPage extends AppCompatActivity {

    private ArrayList<MessageData> messageItems; // list of fragments to be made into pages

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        // create the messages array
        messageItems = new ArrayList<>();
        // creates a messageData object, adds it to the array, and adds the string to it from res

        // create messageData objects, set the messages from res, then add to array
        MessageData m1 = new MessageData();
        m1.setMessage(getString(R.string.instructions_msg_one));
        MessageData m2 = new MessageData();
        m2.setMessage(getString(R.string.instructions_msg_two));
        MessageData m3 = new MessageData();
        m3.setMessage(getString(R.string.instructions_msg_three));

        messageItems.add(m1);
        messageItems.add(m2);
        messageItems.add(m3);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), messageItems);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

    }
}
