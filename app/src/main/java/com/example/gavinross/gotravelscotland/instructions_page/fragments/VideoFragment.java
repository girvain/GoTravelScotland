package com.example.gavinross.gotravelscotland.instructions_page.fragments;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.instructions_page.InstructionsPage;
import com.pixelcan.inkpageindicator.InkPageIndicator;

/**
 * Created by gavinross on 12/12/2017.
 */

public class VideoFragment extends Fragment{

    private VideoView videoView;
    private View rootView;
    private String filePath;
    private ImageButton largePlayButton;
    private int fragAdaptPos;
    private VideoView fullscreenVideoView;
    private FullScreenMediaController mc;
    private boolean fullscreen;
    private InkPageIndicator inkPageIndicator;
    InstructionsPage instructionsPage;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.video_fragment, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.fragmentVideoView);

        // get ref'filePath to all the buttons
        largePlayButton = (ImageButton)rootView.findViewById(R.id.largePlayButton);
        fullscreenVideoView = (VideoView) rootView.findViewById(R.id.videoView5);

        filePath = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;
        videoView.setVideoPath(filePath);
        fullscreenVideoView.setVideoPath(filePath);
        videoView.seekTo(2000);

        mc = new FullScreenMediaController(getContext(), videoView, fullscreenVideoView);
        mc.show(5); // how long controls are displayed

        instructionsPage = (InstructionsPage)this.getActivity();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                /*
                This has been put before the size change listener (which was not actually nessesary)
                so that the getActivity.getSupportActionBar().show() can act first which solves the
                media controller displaying above the video.
                 */
                ((AppCompatActivity) getActivity()).getSupportActionBar().show();


                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        fullscreenVideoView.clearFocus();
                        videoView.requestFocus();
                        videoView.setMediaController(mc);
                        mc.setAnchorView(videoView);

                        fullscreen = false;
                        // show the swipe dots
                        instructionsPage.findViewById(R.id.indicator).setVisibility(View.VISIBLE);
                        if (inkPageIndicator != null){
                            inkPageIndicator.setVisibility(View.INVISIBLE);
                        }
                        // stops the fake dragging to get the swipe going again if it was stopped
                        if (viewPager.isFakeDragging()) {
                            viewPager.endFakeDrag();
                        }
                    }
                });


            }
        });
        fullscreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // remove the action bar!!!
                ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        videoView.clearFocus();
                        fullscreenVideoView.requestFocus();
                        fullscreenVideoView.setMediaController(mc);
                        mc.setAnchorView(fullscreenVideoView);
                        mc.show(5); // how long controls are displayed

                        fullscreen = true;
                        // hides the swipe dots
                        instructionsPage.findViewById(R.id.indicator).setVisibility(View.INVISIBLE);
                        if (inkPageIndicator != null){
                            inkPageIndicator.setVisibility(View.INVISIBLE);
                        }
                        // stops the dragging
                        viewPager.beginFakeDrag();
                    }
                });

            }
        });


        largePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                largePlayButton.setVisibility(View.INVISIBLE);
                videoView.seekTo(0);
                videoView.start();
            }
        });



        // get a reference to the activity hosting this fragment and find the item index num
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        fragAdaptPos = viewPager.getCurrentItem();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mc != null) {
                    mc.hide();
                }
                videoView.pause();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return rootView;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }
}
