package com.example.gavinross.gotravelscotland.instructions_page.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gavinross.gotravelscotland.HomePage;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.InstructionsPage;

/**
 * Created by gavinross on 15/12/2017.
 */

public class MessageFragWithButton extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.message_frag_with_button, container, false);

        Button button =(Button) rootView.findViewById(R.id.letsStart);
        button.setText(R.string.lets_begin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomePageIntent = new Intent(getContext(), HomePage.class);
                startActivity(HomePageIntent);
            }
        });
        return rootView;
    }
}
