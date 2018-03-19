package com.example.gavinross.gotravelscotland;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.whats_on_classes.Advert;
import com.example.gavinross.gotravelscotland.whats_on_classes.AdvertArrayAdapter;

import java.util.ArrayList;

/**
 * Created by gavin on 18/03/18.
 */

public class WhatsOn extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whats_on);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        TextView heading = (TextView) findViewById(R.id.heading_one);
        heading.setText(R.string.whatson_page_title);

        ArrayList<Advert> adverts = new ArrayList<Advert>();
        adverts.add(new Advert(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));
        adverts.add(new Advert(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));
        adverts.add(new Advert(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));
        adverts.add(new Advert(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));
        adverts.add(new Advert(R.drawable.dragon, "Dragon Shop",
                "aaah ya know wee sell dragons and various other ancient materials. We " +
                        "also have a dildo that is over a thousand years old and rumoured to be" +
                        "the first original sex toy known to man. Massive!"));

        AdvertArrayAdapter adapter = new AdvertArrayAdapter(this, adverts);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }

}
