package com.example.gavinross.gotravelscotland;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


/**
 * Created by gavinross on 13/12/2017.
 */

public class HomePage extends AppCompatActivity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_page_ui);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        setButtonText("Video Tour", "Children", "Entertainment");

        // button listener for Start Here button
        Button startTour = (Button) findViewById(R.id.button_one);
        startTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomePageIntent = new Intent(HomePage.this, TourHomePage.class);
                startActivity(HomePageIntent);
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
