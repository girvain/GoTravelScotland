package com.example.gavinross.gotravelscotland.viewpager_content.fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.TourHomePage;
import com.example.gavinross.gotravelscotland.viewpager_content.FragContainer;

/**
 * Created by gavinross on 13/12/2017.
 */

public class TourPageAd extends Fragment{

    private VideoView videoView;
    private FullScreenMediaController mc;
    private View rootView;
    private FragContainer fragContainer;
    private ViewPager viewPager;

    private int resId;
    private int nextActivity;
    private VideoView fullscreenVideoView;
    private Button startPartTwoButton;
    private boolean adPlayed;
    private MediaPlayer mp;

    public static TourPageAd newInstance(int resId) {

        Bundle bundle = new Bundle();

        bundle.putInt("resId", resId);

        TourPageAd fragment = new TourPageAd();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            resId = bundle.getInt("resId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.tour_slide_ad, container, false);

        readBundle(getArguments()); // get data from bundle and put it in fields

        String videoFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
                resId;


        startPartTwoButton = (Button)rootView.findViewById(R.id.startPartTwoButton);
        startPartTwoButton.setText(R.string.start_next_tour_button_text);

        // ref to the parent activity
        fragContainer = (FragContainer)this.getActivity();



        fullscreenVideoView  = (VideoView) rootView.findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoFilePath);
        //videoView.seekTo(2000);

        mc = new FullScreenMediaController(getContext(), fullscreenVideoView);
        mc.show(5); // how long controls are displayed


        fullscreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // remove the action bar!!!
                ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        fullscreenVideoView.requestFocus();

                        /* Fuck it, just hide the whole media controler until i can control the
                            moving of the seek bar

                        fullscreenVideoView.setMediaController(mc);
                        mc.setAnchorView(fullscreenVideoView);
                        mc.show(5); // how long controls are displayed
                        */

                        // hides the swipe dots
                        fragContainer.findViewById(R.id.indicator).setVisibility(View.INVISIBLE);
                        // stops the dragging
                        viewPager.beginFakeDrag();
                    }
                });

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        fullscreenVideoView.setVisibility(View.INVISIBLE);
                        adPlayed = true; // set state to true coz ad is now played
                        startPartTwoButton.setVisibility(View.VISIBLE); //show button after video

                        // This is what broke it i think
                        fullscreenVideoView.clearFocus();

                        // show the swipe dots
                        fragContainer.findViewById(R.id.indicator).setVisibility(View.VISIBLE);
                        // stops the fake dragging to get the swipe going again if it was stopped
                        if (viewPager.isFakeDragging()) {
                            viewPager.endFakeDrag();
                        }

                        // show the action bar again
                        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
                    }
                });


            }
        });


        // get a reference to the activity hosting this fragment and find the item index num
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        //fragAdaptPos = viewPager.getCurrentItem();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mc != null) {
                    mc.hide();
                }
                //videoView.pause();
            }

            @Override
            public void onPageSelected(int position) {
                if (!adPlayed) {
                    startPartTwoButton.setVisibility(View.INVISIBLE); // hide button after click
                    fullscreenVideoView.setVisibility(View.VISIBLE); // show the video
                    fullscreenVideoView.start();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // This sets the visability of video and button after the ad has played
        fullscreenVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startPartTwoButton.setVisibility(View.VISIBLE); // hide video
                fullscreenVideoView.setVisibility(View.INVISIBLE); // show the button
            }
        });

        startPartTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), TourHomePage.class);
                startActivity(intent);

            }
        });

        return rootView;
    }
}















//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//
//        final View rootView = inflater.inflate(R.layout.tour_slide_ad, container, false);
//
//        readBundle(getArguments()); // get data from bundle and put it in fields
//
//        String videoFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
//                resId;
//
//        // ref to the parent activity
//        fragContainer = (FragContainer)this.getActivity();
//
//
//        fullscreenVideoView  = (VideoView) rootView.findViewById(R.id.fullscreenVideoView);
//        fullscreenVideoView.setVideoPath(videoFilePath);
//
//
//        mc = new FullScreenMediaController(getContext(), fullscreenVideoView);
//        mc.show(5); // how long controls are displayed
//
//        // button listener for  part2Button
//        final Button part2Button = (Button) rootView.findViewById(R.id.part2Button);
//        part2Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!adPlayed) {
//                    //fullscreenVideoView.setVisibility(View.VISIBLE);
//                    part2Button.setVisibility(View.INVISIBLE);
//                    fullscreenVideoView.start();
//
//                }
//            }
//        });
//
//        fullscreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                // remove the action bar!!!
//                ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
//
//                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
//                    @Override
//                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
//                        //videoView.clearFocus();
//                        fullscreenVideoView.requestFocus();
//                        fullscreenVideoView.setMediaController(mc);
//                        mc.setAnchorView(fullscreenVideoView);
//                        mc.show(5); // how long controls are displayed
//
//                        // hides the swipe dots
//                        fragContainer.findViewById(R.id.indicator).setVisibility(View.INVISIBLE);
//                        // stops the dragging
//                        viewPager.beginFakeDrag();
//                    }
//                });
//
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        fullscreenVideoView.clearFocus();
//                        fullscreenVideoView.setVisibility(View.GONE);
//
//                        adPlayed = true;
//                        part2Button.setVisibility(View.VISIBLE);
//
//                        // hides the swipe dots
//                        //fragContainer.findViewById(R.id.indicator).setVisibility(View.VISIBLE);
//                        // show the action bar again
//                        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
//                        viewPager.beginFakeDrag();
//                    }
//                });
//
//
//            }
//
//        });
