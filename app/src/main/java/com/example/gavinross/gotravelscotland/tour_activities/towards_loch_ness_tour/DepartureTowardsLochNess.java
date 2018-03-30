package com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.tour_activities.start_here_tour.DepartureStartHere;
import com.example.gavinross.gotravelscotland.tour_activities.start_here_tour.EdinburghPage;

public class DepartureTowardsLochNess extends AppCompatActivity {
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

        mHeadingTextView.setText(R.string.departure_towards_loch_ness_title);
        mParagraphView.setText(R.string.departure_towards_loch_ness_para);
        mImageView.setImageResource(R.drawable.dragon);

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepartureTowardsLochNess.this, KilliecrankiePage.class);
                startActivity(intent);

            }
        });
    }
}
