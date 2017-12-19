package com.example.gavinross.gotravelscotland.instructions_page.fragments;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
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
    private VideoView fullscreenVideoView;
    private View rootView;
    private ImageButton fullscreenButton;
    private ImageButton playButton;
    private ImageButton pauseButton;
    private ImageButton largePlayButton;
    private SeekBar seekBar;
    private int videoPosition;
    private int fragAdaptPos;
    private Timer timer;
    private boolean returnedFromFullscreen = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.video_fragment, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.fragmentVideoView);
        fullscreenVideoView =(VideoView) rootView.findViewById(R.id.fullscreenVideoView);

        // get ref's to all the buttons
        largePlayButton = (ImageButton)rootView.findViewById(R.id.largePlayButton);
        playButton = (ImageButton)rootView.findViewById(R.id.playButton);
        pauseButton = (ImageButton)rootView.findViewById(R.id.pauseButton);
        seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
        fullscreenButton = (ImageButton)rootView.findViewById(R.id.fullscreenButton);

        final String videoPath = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;
        videoView.setVideoPath(videoPath);
        videoView.requestFocus();

        videoPosition = getActivity().getIntent().getIntExtra("videoPosition", 0);
        fragAdaptPos = getActivity().getIntent().getIntExtra("fragAdaptPos", 0);
        returnedFromFullscreen = getActivity().getIntent().getBooleanExtra(
                "returnedFromFullscreen", false);


        if (returnedFromFullscreen) {
            videoView.seekTo(videoPosition);
            videoView.start();
            largePlayButton.setVisibility(View.INVISIBLE);
        }



        // listener to display the media player
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMediaControls();
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        removeMediaControls();
                    }
                },4000);
            }
        });


        largePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                largePlayButton.setVisibility(View.INVISIBLE);
                videoView.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.pause();
                // swap the pause and play
                playButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.INVISIBLE);
            }
        });



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (videoView.isPlaying()) {
                    //playButton.setVisibility(View.INVISIBLE);
                }
                else if (!videoView.hasFocus()) {
                    videoView.pause();
                }
                else if (!videoView.isShown()){
                    videoView.pause();
                }
                else
                    videoView.start();
                // swap the pause and play
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.INVISIBLE);
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progChanged = videoView.getCurrentPosition();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                videoView.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                videoView.seekTo(progChanged);
                videoView.start();
            }
        });


        // get a reference to the activity hosting this fragment and find the item index num
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        fragAdaptPos = viewPager.getCurrentItem();

        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //videoView.pause();
                videoPosition = videoView.getCurrentPosition();
                videoView.stopPlayback();
                videoView.setVisibility(View.GONE);

                fullscreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                    }
                });

                MediaController mc = new MediaController(getContext());
                fullscreenVideoView.setMediaController(mc);
                mc.setAnchorView(fullscreenVideoView);

                fullscreenVideoView.setVideoPath(videoPath);
                fullscreenVideoView.setVisibility(View.VISIBLE);
                fullscreenVideoView.seekTo(videoPosition);
                fullscreenVideoView.start();
                ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

//                Intent intent = new Intent(getContext(), FullScreenVideoActivity.class);
//                intent.putExtra("videoPosition", videoPosition);
//
//                // get a reference to the activity hosting this fragment and find the item index num
//                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
//                intent.putExtra("fragAdaptPos", viewPager.getCurrentItem());
//
//                intent.putExtra("fileId", R.raw.intro_tour);
//                // then send the intent with the data to the FullScreenVideoActivity
//                startActivity(intent);
            }
        });

        return rootView;
    }

    public int getFragAdaptPos() {
        return fragAdaptPos;
    }

    public void displayMediaControls() {
        fullscreenButton.setVisibility(View.VISIBLE);
        seekBar.setVisibility(View.VISIBLE);
        if (videoView.isPlaying()) {
            pauseButton.setVisibility(View.VISIBLE);
        }
        else
            playButton.setVisibility(View.VISIBLE);
    }

    public void removeMediaControls() {
        fullscreenButton.setVisibility(View.INVISIBLE);
        playButton.setVisibility(View.INVISIBLE);
        seekBar.setVisibility(View.INVISIBLE);
        pauseButton.setVisibility(View.INVISIBLE);
    }




}
