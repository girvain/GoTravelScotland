package com.example.gavinross.gotravelscotland.tour_one.fragments;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 13/12/2017.
 */

public class TourSlidePage extends android.support.v4.app.Fragment{
    private VideoView videoView;
    private MediaController mc;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tour_silde_page, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.tour_info_video);

        // insert the video name here!
        String s = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;

        videoView.setVideoPath(s);
        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                /*
                 * add media controller
                 */
                        mc = new MediaController(getActivity());
                        videoView.setMediaController(mc);
                /*
                 * and set its position on screen
                 */
                        mc.setAnchorView(videoView);
                    }
                });
            }
        });

        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                else if (!videoView.hasFocus()) {
                    videoView.pause();
                }
                else if (!videoView.isShown()){
                    videoView.pause();
                }
                else
                    videoView.start();

                return false;
            }
        });

        return rootView;
    }
}
