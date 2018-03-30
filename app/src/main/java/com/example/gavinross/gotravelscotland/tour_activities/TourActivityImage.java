package com.example.gavinross.gotravelscotland.tour_activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.viewpager_content.fragments.TourPageImage;

public class TourActivityImage extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_slide_page);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        TextView mHeadingTextView = (TextView) findViewById(R.id.heading);
        TextView mParagraphView = (TextView) findViewById(R.id.paragragh);

        mHeadingTextView.setText(R.string.departure_start_here_title);
        mParagraphView.setText(R.string.departure_start_here_para);

        ImageView mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.dragon);

    }

}
