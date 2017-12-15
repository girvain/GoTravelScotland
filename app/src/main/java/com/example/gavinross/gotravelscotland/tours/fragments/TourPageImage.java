package com.example.gavinross.gotravelscotland.tours.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 13/12/2017.
 */

public class TourPageImage extends Fragment {

    private String headingText; // for holding text from newInstance to bundle
    private String paragraphText; // to then be passed to textViews
    private int resId;

    private ImageView mImageView;
    private TextView mHeadingTextView;
    private TextView mParagraphView;

    public static TourPageImage newInstance(String headingText, String paragraphText, int resId) {

        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);
        bundle.putString("paragraph", paragraphText);
        bundle.putInt("resId", resId);

        TourPageImage fragment = new TourPageImage();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            headingText = bundle.getString("heading");
            paragraphText = bundle.getString("paragraph");
            resId = bundle.getInt("resId");

        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.the_departure_page, container, false);

        mHeadingTextView = (TextView) rootView.findViewById(R.id.heading);
        mParagraphView = (TextView) rootView.findViewById(R.id.paragragh);

        readBundle(getArguments()); // sets all the fields

        mHeadingTextView.setText(headingText);
        mParagraphView.setText(paragraphText);


        mImageView = (ImageView) rootView.findViewById(R.id.imageView);
        mImageView.setImageResource(resId);

        return rootView;
    }


}
