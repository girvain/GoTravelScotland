package com.example.gavinross.gotravelscotland.fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

    private VideoView videoView;
    private MediaController mc;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.video_fragment, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.fragmentVideoView);

        String s = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;
        videoView.setVideoPath(s);
        videoView.requestFocus();

        mc = new MediaController(this.getActivity());
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);


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


        return rootView;
    }

}
