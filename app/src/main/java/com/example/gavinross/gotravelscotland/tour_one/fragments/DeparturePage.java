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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.the_departure_page, container, false);

        return rootView;
    }
}
