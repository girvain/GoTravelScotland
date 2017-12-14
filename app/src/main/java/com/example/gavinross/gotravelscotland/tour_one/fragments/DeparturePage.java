package com.example.gavinross.gotravelscotland.tour_one.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 13/12/2017.
 */

public class DeparturePage extends Fragment {

    private String headingText;
    private TextView mHeadingTextView;

    public static DeparturePage newInstance(String headingText) {
        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);

        DeparturePage fragment = new DeparturePage();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            headingText = bundle.getString("heading");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.the_departure_page, container, false);

        mHeadingTextView = (TextView) rootView.findViewById(R.id.heading);

        readBundle(getArguments());

        mHeadingTextView.setText(String.format(headingText));

        return rootView;

    }


}
