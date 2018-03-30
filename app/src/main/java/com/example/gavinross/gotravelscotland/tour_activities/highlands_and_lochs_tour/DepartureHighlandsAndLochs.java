package com.example.gavinross.gotravelscotland.tour_activities.highlands_and_lochs_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour.DepartureTowardsLochNess;
import com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour.KilliecrankiePage;

public class DepartureHighlandsAndLochs extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_departure_page);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        TextView mHeadingTextView = (TextView) findViewById(R.id.heading);
        TextView mParagraphView = (TextView) findViewById(R.id.paragragh);
        ImageView mImageView = (ImageView) findViewById(R.id.imageView);
        ImageButton nextActivity = (ImageButton) findViewById(R.id.nextSlideButton);

        mHeadingTextView.setText(R.string.departure_highlands_and_lochs_title);
        mParagraphView.setText(R.string.departure_highlands_and_lochs_para);
        mImageView.setImageResource(R.drawable.dragon);

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepartureHighlandsAndLochs.this, CommandoMemorialPage.class);
                startActivity(intent);

            }
        });
    }
}
