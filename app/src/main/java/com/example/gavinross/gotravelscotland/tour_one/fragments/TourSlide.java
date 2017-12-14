package com.example.gavinross.gotravelscotland.tour_one.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 13/12/2017.
 */

public class TourSlide extends Fragment {

    private int layoutType = 1;
    private String headingText; // for holding text from newInstance to bundle
    private String paragraphText; // to then be passed to textViews
    private int resId;
    private int videoId;

    private ImageView mImageView;
    private VideoView mVideoView;
    private TextView mHeadingTextView;
    private TextView mParagraphView;

    public static TourSlide newInstance(String headingText, String paragraphText, int resId, int layoutType) {

        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);
        bundle.putString("paragraph", paragraphText);
        bundle.putInt("resId", resId);
        bundle.putInt("layoutType", layoutType);

        TourSlide fragment = new TourSlide();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            headingText = bundle.getString("heading");
            paragraphText = bundle.getString("paragraph");
            resId = bundle.getInt("resId");
            layoutType = bundle.getInt("layoutType");

        }
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (layoutType == 1)
            this.layoutType = R.layout.the_departure_page;
        else if (layoutType == 2)
            this.layoutType = R.layout.tour_silde_page;
        else if (layoutType == 3)
            this.layoutType = R.layout.tour_slide_end_page;

        View rootView = inflater.inflate(this.layoutType, container, false);

        mHeadingTextView = (TextView) rootView.findViewById(R.id.heading);
        mParagraphView = (TextView) rootView.findViewById(R.id.paragragh);

        readBundle(getArguments()); // sets all the fields

        mHeadingTextView.setText(headingText);
        mParagraphView.setText(paragraphText);

        if (layoutType == 1) {
            mImageView = (ImageView) rootView.findViewById(R.id.imageView);
            mImageView.setImageResource(resId);
        } else if (layoutType == 2) {
            mVideoView = (VideoView) rootView.findViewById(R.id.fragmentVideoView);
            mVideoView.set
        }



        return rootView;
    }


}
