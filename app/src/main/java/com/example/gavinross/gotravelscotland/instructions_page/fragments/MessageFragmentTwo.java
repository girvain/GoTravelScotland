package com.example.gavinross.gotravelscotland.instructions_page.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 12/12/2017.
 */

public class MessageFragmentTwo extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.message_fragment, container, false);
        TextView textView = (TextView)rootView.findViewById(R.id.msg_fragment_text);
        textView.setText(R.string.instructions_msg_two);
        return rootView;
    }
}
