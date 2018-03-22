package com.example.gavinross.gotravelscotland;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gavinross.gotravelscotland.instructions_page.InstructionsPage;

import java.util.Locale;

/**
 * To do list:
 * > add all the content: images, text and other language text
 * > apply text styles
 * >
 * > extra stuff to add:
 * >    button animation
 * >    pressed in look from the flag buttons when selected
 */

public class MainActivity extends AppCompatActivity {
    private static final String APP_SHARED_PREFS = "com.example.test";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private CheckBox tAndCbox;

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

        // third heading textView
        TextView heading3 = (TextView)findViewById(R.id.textView3);
        heading3.setText(R.string.language_select);

        // checkbox Ref
        tAndCbox = (CheckBox) findViewById(R.id.t_and_c_box);
        tAndCbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogTandC();
            }
        });

        // get the ref to the button
        Button letsStart = (Button) findViewById(R.id.lets_start_button);
        letsStart.setText(R.string.start);
        letsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tAndCbox.isChecked()){
                    Intent languageIntent = new Intent(MainActivity.this, InstructionsPage.class);
                    startActivity(languageIntent);
                } else {
                    openDialogNoTick();
                }

            }
        });

        // language Buttons
        final ImageButton english = (ImageButton) findViewById(R.id.englishButton);
        ImageButton french = (ImageButton) findViewById(R.id.frenchButton);
        ImageButton german= (ImageButton)findViewById(R.id.germanButton);
        ImageButton spanish = (ImageButton) findViewById(R.id.spanishButton);
        ImageButton italian = (ImageButton) findViewById(R.id.italianButton);
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
                restartInLanguage("de"); // this might be wrong
            }
        });
        spanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartInLanguage("es"); // this might be wrong
            }
        });
        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartInLanguage("it"); // this might be wrong
            }
        });

        /* Dialog */


    }

    public void restartInLanguage(String lang) {
        editor.putString("lang", lang);
        editor.commit();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void openDialogTandC() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(R.string.terms_and_conditions_title)
                .setMessage(R.string.terms_and_conditions)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // sets box ticked when the ok button is clicked
                        tAndCbox.setChecked(true);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // sets box not ticked when the cancel button is clicked
                        tAndCbox.setChecked(false);
                    }
                })
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void openDialogNoTick() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Terms and Conditions box not checked!")
                .setMessage("You must agree to the terms and conditions to use the app")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



}
