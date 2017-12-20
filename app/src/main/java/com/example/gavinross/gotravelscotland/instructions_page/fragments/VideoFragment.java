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
    private boolean returnedFromFullscreen = false;
    private FullScreenMediaController mc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.video_fragment, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.fragmentVideoView);

        // get ref's to all the buttons
        largePlayButton = (ImageButton)rootView.findViewById(R.id.largePlayButton);

        fullscreenButton = (ImageButton)rootView.findViewById(R.id.fullscreenButton);
        VideoView fullscreenVideoView = (VideoView) rootView.findViewById(R.id.videoView5);

        String s = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;
        videoView.setVideoPath(s);
        videoView.requestFocus();

        videoPosition = getActivity().getIntent().getIntExtra("videoPosition", 0);
        fragAdaptPos = getActivity().getIntent().getIntExtra("fragAdaptPos", 0);

        mc = new FullScreenMediaController(getContext(), videoView, fullscreenVideoView);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                 // change this to an intent passed from the adapter
                videoView.setMediaController(mc);
                mc.setAnchorView(videoView);
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

        viewPager.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                mc.hide();
                return false;
            }
        });

        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //videoView.pause();
                videoPosition = videoView.getCurrentPosition();
                Intent intent = new Intent(getContext(), FullScreenVideoActivity.class);
                intent.putExtra("videoPosition", videoPosition);

                // get a reference to the activity hosting this fragment and find the item index num
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
                intent.putExtra("fragAdaptPos", viewPager.getCurrentItem());

                intent.putExtra("fileId", R.raw.intro_tour);
                // then send the intent with the data to the FullScreenVideoActivity
                startActivity(intent);
            }
        });

        return rootView;
    }

    public int getFragAdaptPos() {
        return fragAdaptPos;
    }

}
