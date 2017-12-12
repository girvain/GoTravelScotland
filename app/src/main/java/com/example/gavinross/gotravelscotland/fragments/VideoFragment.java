package com.example.gavinross.gotravelscotland.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 12/12/2017.
 */

public class VideoFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.video_fragment, container, false);
        VideoView videoView =(VideoView) getActivity().findViewById(R.id.fragmentVideoView);

//        String s = "android.resource://" + getActivity().getPackageName() + "/" +
//                R.raw.intro_tour;
//        videoView.setVideoPath(s);
//        videoView.setMediaController(new MediaController(getActivity()));
//        videoView.requestFocus();
//        videoView.start();
        return rootView;
    }
}
