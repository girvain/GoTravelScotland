package com.example.gavinross.gotravelscotland;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gavin on 18/03/18.
 */

public class Extra extends AppCompatActivity{

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
        headingOne.setText(R.string.extra_page_title);
        headingTwo.setText(R.string.extra_page_para);

        // set the button text
        Button buttonOneRef = (Button) findViewById(R.id.button_one);
        buttonOneRef.setText(R.string.extra_button_text);
        Button buttonOneRef2 = (Button) findViewById(R.id.button_two);
        buttonOneRef2.setText(R.string.whatson_button_text);
        Button buttonOneRef3 = (Button) findViewById(R.id.button_three);
        buttonOneRef3.setText(R.string.shop_button_text);
        Button buttonOneRef4 = (Button) findViewById(R.id.button_four);
        buttonOneRef4.setText(R.string.web_button_text);

        // button listener for extras button
        Button extrasButton = (Button) findViewById(R.id.button_two);
        extrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent WhatsOnPageIntent = new Intent(Extra.this, WhatsOn.class);
                startActivity(WhatsOnPageIntent);
            }
        });
    }
}
