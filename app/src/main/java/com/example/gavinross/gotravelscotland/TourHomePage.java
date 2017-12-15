package com.example.gavinross.gotravelscotland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
        setContentView(R.layout.three_page_ui);

        setButtonText("Start Here", "Into The Highlands", "The Journey Home");


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

    }

    /*
    A method to set all the button text to the input of the method
     */
    public void setButtonText(String button1, String button2, String button3) {
        Button buttonOneRef = (Button) findViewById(R.id.button_one);
        buttonOneRef.setText(button1);
        Button buttonOneRef2 = (Button) findViewById(R.id.button_two);
        buttonOneRef2.setText(button2);
        Button buttonOneRef3 = (Button) findViewById(R.id.button_three);
        buttonOneRef3.setText(button3);
    }
}
