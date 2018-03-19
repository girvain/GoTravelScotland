package com.example.gavinross.gotravelscotland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.tours.TourFragContainer;

/**
 * Created by gavinross on 13/12/2017.
 * This class contains the buttons that create a TourFragContainer object. a number must be
 * passed in as an intent to declare what custom PagerAdapter to use which is what identifies
 * what tour it is.
 */

public class TourHomePage extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_page_ui);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        // set the title and para text
        TextView headingOne = (TextView) findViewById(R.id.heading_one);
        TextView headingTwo = (TextView) findViewById(R.id.heading_two);
        headingOne.setText(R.string.tour_home_page_title);
        headingTwo.setText(R.string.tour_home_page_para);

        // set the button text
        Button buttonOneRef = (Button) findViewById(R.id.button_one);
        buttonOneRef.setText(R.string.start_here_button_text);
        Button buttonOneRef2 = (Button) findViewById(R.id.button_two);
        buttonOneRef2.setText(R.string.towards_loch_ness_button_text);
        Button buttonOneRef3 = (Button) findViewById(R.id.button_three);
        buttonOneRef3.setText(R.string.highlands_and_lochs_button_text);
        Button buttonOneRef4 = (Button) findViewById(R.id.button_four);
        buttonOneRef4.setText(R.string.heros_and_freedom_button_text);

        // button listener for Start Here button
        Button startTour = (Button) findViewById(R.id.button_one);
        startTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourHomePage.this, TourFragContainer.class);
                intent.putExtra("adapterTourOption", 1);
                startActivity(intent);
            }
        });

        // button listener for Start Here button
        Button intoTheHighlands = (Button) findViewById(R.id.button_two);
        intoTheHighlands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourHomePage.this, TourFragContainer.class);
                intent.putExtra("adapterTourOption", 2);
                startActivity(intent);
            }
        });

        // button listener for Start Here button
        Button tourHomePage = (Button) findViewById(R.id.button_three);
        tourHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourHomePage.this, TourFragContainer.class);
                intent.putExtra("adapterTourOption", 2);
                startActivity(intent);
            }
        });

        //button listener for heros and freedom

    }

}
