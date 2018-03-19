package com.example.gavinross.gotravelscotland;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


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

        // set the title and para text
        TextView headingOne = (TextView) findViewById(R.id.heading_one);
        TextView headingTwo = (TextView) findViewById(R.id.heading_two);
        headingOne.setText(R.string.homepage_title);
        headingTwo.setText(R.string.homepage_para);

        // set the button text
        Button buttonOneRef = (Button) findViewById(R.id.button_one);
        buttonOneRef.setText(R.string.video_tour_button_text);
        Button buttonOneRef2 = (Button) findViewById(R.id.button_two);
        buttonOneRef2.setText(R.string.children_button_text);
        Button buttonOneRef3 = (Button) findViewById(R.id.button_three);
        buttonOneRef3.setText(R.string.extras_button_text);

        // button listener for Start Here button
        Button startTour = (Button) findViewById(R.id.button_one);
        startTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomePageIntent = new Intent(HomePage.this, TourHomePage.class);
                startActivity(HomePageIntent);
            }
        });

        // button listener for extras button
        Button extrasButton = (Button) findViewById(R.id.button_three);
        extrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExtraPageIntent = new Intent(HomePage.this, Extra.class);
                startActivity(ExtraPageIntent);
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
