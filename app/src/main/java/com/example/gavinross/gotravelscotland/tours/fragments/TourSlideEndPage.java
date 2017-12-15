package com.example.gavinross.gotravelscotland.tours.fragments;

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
    private VideoView videoViewOne;
    private VideoView videoViewTwo;
    private VideoView videoViewThree;
    private VideoView videoViewFour;
    private MediaController mc;
    private View rootView;
    private MediaPlayer.OnPreparedListener onPreparedListener;

    private String headingText; // for holding text from newInstance to bundle
    private String paragraphText; // to then be passed to textViews
    private int resId1;
    private int resId2;
    private int resId3;
    private int resId4;

    private TextView mHeadingTextView;
    private TextView mParagraphView;

    public static TourSlideEndPage newInstance(String headingText, String paragraphText, int resId1,
                                               int resId2, int resId3, int resId4) {

        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);
        bundle.putString("paragraph", paragraphText);
        bundle.putInt("resId1", resId1);
        bundle.putInt("resId2", resId2);
        bundle.putInt("resId3", resId3);
        bundle.putInt("resId4", resId4);

        TourSlideEndPage fragment = new TourSlideEndPage();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            headingText = bundle.getString("heading");
            paragraphText = bundle.getString("paragraph");
            resId1 = bundle.getInt("resId1");
            resId2 = bundle.getInt("resId2");
            resId3 = bundle.getInt("resId3");
            resId4 = bundle.getInt("resId4");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.tour_slide_end_page, container, false);

        readBundle(getArguments()); // get data from bundle and put it in fields

        mHeadingTextView = (TextView) rootView.findViewById(R.id.heading);
        mParagraphView = (TextView) rootView.findViewById(R.id.paragraph);
        mHeadingTextView.setText(headingText);
        mParagraphView.setText(paragraphText);

        String videoFilePath1 = "android.resource://" + getActivity().getPackageName() + "/" +
                resId1;
        String videoFilePath2 = "android.resource://" + getActivity().getPackageName() + "/" +
                resId2;
        String videoFilePath3 = "android.resource://" + getActivity().getPackageName() + "/" +
                resId3;
        String videoFilePath4 = "android.resource://" + getActivity().getPackageName() + "/" +
                resId4;

        videoViewOne =(VideoView) rootView.findViewById(R.id.videoView1);
        videoViewOne.setVideoPath(videoFilePath1);
        videoViewTwo =(VideoView) rootView.findViewById(R.id.videoView2);
        videoViewTwo.setVideoPath(videoFilePath1);
        videoViewThree =(VideoView) rootView.findViewById(R.id.videoView3);
        videoViewThree.setVideoPath(videoFilePath1);
        videoViewFour =(VideoView) rootView.findViewById(R.id.videoView4);
        videoViewFour.setVideoPath(videoFilePath1);
        videoViewOne.requestFocus();


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
                        videoViewOne.setMediaController(mc);
                /*
                 * and set its position on screen
                 */
                        mc.setAnchorView(videoViewOne);
                    }
                });
            }

        };
        // using the anon with name
        videoViewOne.setOnPreparedListener(onPreparedListener);


        videoViewOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (videoViewOne.isPlaying()) {
                    videoViewOne.pause();
                }
                else if (!videoViewOne.hasFocus()) {
                    videoViewOne.pause();
                }
                else if (!videoViewOne.isShown()){
                    videoViewOne.pause();
                }
                else
                    videoViewOne.start();

                return false;
            }
        });

        //setUpVideoClip(videoViewOne, R.id.videoViewOne);

        return rootView;
    }

    public void setUpVideoClip(VideoView videoView, int viewId) {
        String videoFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
                viewId;

        //videoViewOne = (VideoView)rootView.findViewById(viewId);
        videoView.setVideoPath(videoFilePath);
        videoView.requestFocus();

        videoView.setOnPreparedListener(onPreparedListener);
        MediaController mc = new MediaController(getActivity());
        videoView.setMediaController(mc);
        mc.setAnchorView(videoView);
    }
}
