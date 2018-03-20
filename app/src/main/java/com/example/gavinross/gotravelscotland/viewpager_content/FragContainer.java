package com.example.gavinross.gotravelscotland.viewpager_content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.viewpager_content.Adapters.ChildrensEpisodesAdapter;
import com.example.gavinross.gotravelscotland.viewpager_content.Adapters.IntoTheHighlandsAdapter;
import com.example.gavinross.gotravelscotland.viewpager_content.Adapters.JourneyHomeAdapter;
import com.example.gavinross.gotravelscotland.viewpager_content.Adapters.StartHereAdapter;
import com.pixelcan.inkpageindicator.InkPageIndicator;

/**
 * Created by gavinross on 13/12/2017.
 * This is a container class that will take different custom made pagerAdapters for what ever tour
 * the adapter is programed for.
 */

public class FragContainer extends AppCompatActivity{

    private InkPageIndicator inkPageIndicator;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);


        // get the intent sent by TourHomePage which is the index number stating which adapter
        // to use in this container.
        Intent intent = getIntent();
        int adapterTourOption = intent.getIntExtra("adapterTourOption", 0);

        if (adapterTourOption == 1) {
            // Create an adapter that knows which fragment should be shown on each page
            StartHereAdapter adapter = new StartHereAdapter(
                    getSupportFragmentManager(), this);
            // Set the adapter onto the view pager
            viewPager.setAdapter(adapter);
        }
        else if (adapterTourOption == 2) {
            // Create an adapter that knows which fragment should be shown on each page
            IntoTheHighlandsAdapter adapter = new IntoTheHighlandsAdapter(
                    getSupportFragmentManager(), this);
            // Set the adapter onto the view pager
            viewPager.setAdapter(adapter);
        }
        else if (adapterTourOption == 3) {
            JourneyHomeAdapter adapter = new JourneyHomeAdapter(getSupportFragmentManager(),
                    this);
            viewPager.setAdapter(adapter);
        }
        else if (adapterTourOption == 4) {
            ChildrensEpisodesAdapter adapter = new ChildrensEpisodesAdapter(getSupportFragmentManager(),
                    this);
            viewPager.setAdapter(adapter);
        }


        inkPageIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        inkPageIndicator.setViewPager(viewPager);



//        Button startTour = (Button) findViewById(R.id.start_tour_button);
//        startTour.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent HomePageIntent = new Intent(FragContainer.this, HomePage.class);
//                startActivity(HomePageIntent);
//            }
//        });
    }
}