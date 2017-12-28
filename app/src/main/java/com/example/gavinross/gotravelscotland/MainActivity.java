package com.example.gavinross.gotravelscotland;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

/**
 * To do list:
 * > try and make the main classes use only one three button class with intents and
 *   use this.finish() to close current activity while moving to the next
 * > set to permently in landscape
 * > add all the content
 * > apply text styles
 * > put flags on buttons
 * > update images
 * > add new or fix button animation
 */

public class MainActivity extends AppCompatActivity {
    private static final String APP_SHARED_PREFS = "com.example.test";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Language change content
        settings=getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        editor=settings.edit();

        Locale locale = new Locale(settings.getString("lang", "default-lang"));
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        // end of Language change content

        // hide the action bar on the first page
        getSupportActionBar().hide();

        // second heading textView
        TextView heading2 = (TextView)findViewById(R.id.textView2);
        heading2.setText(R.string.main_paragraph);

        // get the ref to the button
        Button letsStart = (Button) findViewById(R.id.lets_start_button);
        letsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent languageIntent = new Intent(MainActivity.this, LanguageSelect.class);
                startActivity(languageIntent);
            }
        });

        // language Buttons
        ImageButton english = (ImageButton) findViewById(R.id.englishButton);
        ImageButton french = (ImageButton) findViewById(R.id.frenchButton);
        ImageButton german= (ImageButton)findViewById(R.id.germanButton);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartInLanguage("en");
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartInLanguage("fr");
            }
        });
        german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartInLanguage("ge"); // this might be wrong
            }
        });
    }

    public void restartInLanguage(String lang) {
        editor.putString("lang", lang);
        editor.commit();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
