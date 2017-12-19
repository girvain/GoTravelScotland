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
import android.view.SurfaceView;
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
    private ImageButton largePlayButton;
    private ImageButton fullscreenButton;
    private ImageButton playButton;
    private ImageButton pauseButton;
    private SeekBar seekBar;
    private ImageButton fullscreenButtonLarge;
    private ImageButton playButtonLarge;
    private ImageButton pauseButtonLarge;
    private SeekBar seekBarLarge;

    private int videoPosition;
    private int fragAdaptPos;
    private Timer timer;
    private boolean fullscreenDisplay = false;
    private boolean beenPlayed = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.video_fragment, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.fragmentVideoView);
        fullscreenVideoView =(VideoView) rootView.findViewById(R.id.fullscreenVideoView);

        // get ref's to all the buttons
        largePlayButton = (ImageButton)rootView.findViewById(R.id.largePlayButton);
        // standard media controls
        playButton = (ImageButton)rootView.findViewById(R.id.playButton);
        pauseButton = (ImageButton)rootView.findViewById(R.id.pauseButton);
        seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
        fullscreenButton = (ImageButton)rootView.findViewById(R.id.fullscreenButton);
        // fullscreen media controls
        playButtonLarge = (ImageButton)rootView.findViewById(R.id.playButtonLarge);
        pauseButtonLarge = (ImageButton)rootView.findViewById(R.id.pauseButtonLarge);
        seekBarLarge = (SeekBar) rootView.findViewById(R.id.seekBarLarge);
        fullscreenButtonLarge = (ImageButton)rootView.findViewById(R.id.fullscreenButtonLarge);



        final String videoPath = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;
        videoView.setVideoPath(videoPath);
        videoView.requestFocus();

        if (beenPlayed == true) {
            largePlayButton.setVisibility(View.GONE);
        }

        // Listener to set and display the media controls
        View.OnClickListener mediaControlsListener = new View.OnClickListener() {
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
        };


        // listener to display the media player
        videoView.setOnClickListener(mediaControlsListener);
        fullscreenVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMediaControlsLarge();
                Log.v("VideoFragment", "LAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRRRGGGGGGEEE");
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        removeMediaControlsLarge();
                    }
                },4000);
            }
        });


        // The one off big play icon displayed before the video is played
        largePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                largePlayButton.setVisibility(View.INVISIBLE);
                videoView.start();
            }
        });

        // Pause Listeners
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.pause();
                // swap the pause and play
                playButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.INVISIBLE);
            }
        });
        pauseButtonLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.pause();
                // swap the pause and play
                playButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.INVISIBLE);
            }
        });


        // Play listeners
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.start();
                // swap the pause and play
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.INVISIBLE);
            }
        });
        playButtonLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.start();
                // swap the pause and play
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.INVISIBLE);
            }
        });

        // SeekBar listeners
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
        seekBarLarge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        // fullScreen listeners
        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fullscreenDisplay == false) {
                    // handle current video view
                    videoPosition = videoView.getCurrentPosition();
                    videoView.stopPlayback();
                    videoView.setVisibility(View.GONE);
                    removeMediaControls();
                    // prepare new video view
                    fullscreenVideoView.seekTo(videoPosition);
                    fullscreenVideoView.start();
                    fullscreenDisplay = true;
                }
                else {
                    videoPosition = videoView.getCurrentPosition();
                    fullscreenVideoView.stopPlayback();
                    fullscreenVideoView.setVisibility(View.GONE);
                    removeMediaControlsLarge();
                    // prepare new video
                    videoView.seekTo(videoPosition);
                    videoView.start();
                    fullscreenDisplay = false;
                }


                fullscreenVideoView.setVideoPath(videoPath);
                fullscreenVideoView.setVisibility(View.VISIBLE);
                fullscreenVideoView.seekTo(videoPosition);
                fullscreenVideoView.start();
                ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

            }
        });
        fullscreenButtonLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fullscreenDisplay == false) {
                    // handle current video view
                    videoPosition = videoView.getCurrentPosition();
                    videoView.stopPlayback();
                    videoView.setVisibility(View.GONE);
                    removeMediaControls();
                    // prepare new video view
                    fullscreenVideoView.seekTo(videoPosition);
                    fullscreenVideoView.start();
                    fullscreenDisplay = true;
                }
                else {
                    videoPosition = videoView.getCurrentPosition();
                    fullscreenVideoView.stopPlayback();
                    fullscreenVideoView.setVisibility(View.GONE);
                    removeMediaControlsLarge();
                    // prepare new video
                    videoView.seekTo(videoPosition);
                    videoView.start();
                    fullscreenDisplay = false;
                }


                videoView.setVideoPath(videoPath);
                videoView.setVisibility(View.VISIBLE);
                videoView.seekTo(videoPosition);
                videoView.start();
                ((AppCompatActivity) getActivity()).getSupportActionBar().show();

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

    public void displayMediaControlsLarge() {
        fullscreenButtonLarge.setVisibility(View.VISIBLE);
        seekBarLarge.setVisibility(View.VISIBLE);
        if (fullscreenVideoView.isPlaying()) {
            pauseButtonLarge.setVisibility(View.VISIBLE);
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

    public void removeMediaControlsLarge() {
        fullscreenButtonLarge.setVisibility(View.INVISIBLE);
        playButtonLarge.setVisibility(View.INVISIBLE);
        seekBarLarge.setVisibility(View.INVISIBLE);
        pauseButtonLarge.setVisibility(View.INVISIBLE);
    }




}
