package com.example.gavinross.gotravelscotland.tour_one;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 13/12/2017.
 */

public class TourOneContainer extends AppCompatActivity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        StartHereFragmentPagerAdapter adapter = new StartHereFragmentPagerAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


//        Button startTour = (Button) findViewById(R.id.start_tour_button);
//        startTour.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent HomePageIntent = new Intent(TourOneContainer.this, HomePage.class);
//                startActivity(HomePageIntent);
//            }
//        });
    }
}
