package com.example.gavinross.gotravelscotland.tour_one.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
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
 * Created by gavinross on 14/12/2017.
 */

public class TourSlideEndPage extends Fragment {
    private VideoView videoView;
    private MediaController mc;
    private View rootView;
    private MediaPlayer.OnPreparedListener onPreparedListener;

    private String headingText; // for holding text from newInstance to bundle
    private String paragraphText; // to then be passed to textViews
    private int resId;

    private TextView mHeadingTextView;
    private TextView mParagraphView;

    public static TourSlideEndPage newInstance(String headingText, String paragraphText, int resId) {

        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);
        bundle.putString("paragraph", paragraphText);
        bundle.putInt("resId", resId);

        TourSlideEndPage fragment = new TourSlideEndPage();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.tour_slide_end_page, container, false);

        readBundle(getArguments()); // get data from bundle and put it in fields

        String videoFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
                resId;

        mHeadingTextView = (TextView) rootView.findViewById(R.id.heading);
        mParagraphView = (TextView) rootView.findViewById(R.id.paragraph);
        mHeadingTextView.setText(headingText);
        mParagraphView.setText(paragraphText);


        videoView =(VideoView) rootView.findViewById(R.id.videoView3);
        videoView.setVideoPath(videoFilePath);
        videoView.requestFocus();


        // This sets the media controller to be the same size as the video when its resized
        onPreparedListener = new MediaPlayer.OnPreparedListener() {
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

        };
        // using the anon with name
        videoView.setOnPreparedListener(onPreparedListener);


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

        //setUpVideoClip(videoView, R.id.videoView);

        return rootView;
    }

    public void setUpVideoClip(VideoView videoView, int viewId) {
        String videoFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
                viewId;

        //videoView = (VideoView)rootView.findViewById(viewId);
        videoView.setVideoPath(videoFilePath);
        videoView.requestFocus();

        videoView.setOnPreparedListener(onPreparedListener);
        MediaController mc = new MediaController(getActivity());
        videoView.setMediaController(mc);
        mc.setAnchorView(videoView);
    }
}