package com.example.gavinross.gotravelscotland;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * To do list:
 * > fix media controller traveling around the slides
 * > clear resources from the video player after each slide
 * > try and make the main classes use only one three button class with intents and
 *   use this.finish() to close current activity while moving to the next
 * > get multi language support
 * > get fullscreen feature on videos
 * > set to permently in landscape
 * > add all the content
 * > style the beast
 * > top graphic logo
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hide the action bar on the first page
        getSupportActionBar().hide();

        // get the ref to the button
        Button letsStart = (Button) findViewById(R.id.lets_start_button);

        letsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent languageIntent = new Intent(MainActivity.this, LanguageSelect.class);
                startActivity(languageIntent);
            }
        });
    }
}
