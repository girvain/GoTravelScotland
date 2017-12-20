package com.example.gavinross.gotravelscotland.instructions_page.fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.FullScreenVideoActivity;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.InstructionsPage;

import java.util.Timer;
import java.util.TimerTask;

import static android.app.Activity.RESULT_OK;

/**
 * Created by gavinross on 12/12/2017.
 */

public class VideoFragment extends Fragment{

    private VideoView videoView;
    private View rootView;
    private ImageButton fullscreenButton;
    private ImageButton largePlayButton;
    private int videoPosition;
    private int fragAdaptPos;
    VideoView fullscreenVideoView;
    private FullScreenMediaController mc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.video_fragment, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.fragmentVideoView);

        // get ref's to all the buttons
        largePlayButton = (ImageButton)rootView.findViewById(R.id.largePlayButton);

        fullscreenButton = (ImageButton)rootView.findViewById(R.id.fullscreenButton);
        fullscreenVideoView = (VideoView) rootView.findViewById(R.id.videoView5);

        String s = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;
        videoView.setVideoPath(s);
        fullscreenVideoView.setVideoPath(s);
        //videoView.requestFocus();

        videoPosition = getActivity().getIntent().getIntExtra("videoPosition", 0);
        fragAdaptPos = getActivity().getIntent().getIntExtra("fragAdaptPos", 0);

        mc = new FullScreenMediaController(getContext(), videoView, fullscreenVideoView);
        mc.show(5);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                 // change this to an intent passed from the adapter
                videoView.setMediaController(mc);
                mc.setAnchorView(videoView);
                ((AppCompatActivity) getActivity()).getSupportActionBar().show();
            }
        });
        fullscreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // change this to an intent passed from the adapter
                fullscreenVideoView.setMediaController(mc);
                mc.setAnchorView(fullscreenVideoView);
                // remove the action bar!!!
                ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
            }
        });



        largePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                largePlayButton.setVisibility(View.INVISIBLE);
                videoView.start();
            }
        });



        // get a reference to the activity hosting this fragment and find the item index num
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        fragAdaptPos = viewPager.getCurrentItem();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mc.hide();

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                videoView.pause();
            }
        });


        return rootView;
    }

    public int getFragAdaptPos() {
        return fragAdaptPos;
    }

    public VideoView getVideoView() {
        return videoView;
    }

    public VideoView getFullscreenVideoView() {
        return fullscreenVideoView;
    }
}
