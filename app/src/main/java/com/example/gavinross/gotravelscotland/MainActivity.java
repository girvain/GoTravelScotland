package com.example.gavinross.gotravelscotland;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * To do list:
 * > try and make the main classes use only one three button class with intents and
 *   use this.finish() to close current activity while moving to the next
 * > get multi language support
 * > set to permently in landscape
 * > add all the content
 * > apply text styles
 * > put flags on buttons
 * > update images
 * > add new or fix button animation
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
