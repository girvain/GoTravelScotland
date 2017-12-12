package com.example.gavinross.gotravelscotland;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gavinross on 12/12/2017.
 */

public class MessageFragment extends Fragment {

    private String message; // the input from the adapter
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //setMessage("test");

        View fragment = inflater.inflate(R.layout.message_fragment, container, false);
        textView = (TextView) fragment.findViewById(R.id.msg_fragment_text);
        textView.setText(message);
        return fragment;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        // set the text in the actual textView in the fragment
        //textView.setText(message);
    }
}
