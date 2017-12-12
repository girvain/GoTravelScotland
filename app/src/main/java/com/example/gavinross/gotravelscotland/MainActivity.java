package com.example.gavinross.gotravelscotland;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
