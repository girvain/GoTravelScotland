package com.example.gavinross.gotravelscotland.instructions_page.fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.FullScreenVideoActivity;
import com.example.gavinross.gotravelscotland.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by gavinross on 12/12/2017.
 */

public class VideoFragment extends Fragment{

    private VideoView videoView;
    private FullScreenMediaController mc;
    private View rootView;
    private ImageButton fullscreenButton;
    private int videoPosition;
    private int fragAdaptPos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.video_fragment, container, false);
        videoView =(VideoView) rootView.findViewById(R.id.fragmentVideoView);

        String s = "android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.intro_tour;
        videoView.setVideoPath(s);
        videoView.requestFocus();

        videoPosition = getActivity().getIntent().getIntExtra("videoPosition", 0);
        fragAdaptPos = getActivity().getIntent().getIntExtra("fragAdaptPos", 0);

        videoView.seekTo(videoPosition);
        videoView.start();


        //mc = new MediaController(this.getActivity());
        //mc.setAnchorView(videoView);
        //videoView.setMediaController(mc);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                /*
                 * add media controller
                 */
                        mc = new FullScreenMediaController(getActivity(),R.raw.intro_tour);
                        videoView.setMediaController(mc);

                /*
                 * and set its position on screen
                 */
                        mc.setAnchorView(videoView);
                    }
                });
            }
        });

        /*
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
        */


        fullscreenButton = (ImageButton)rootView.findViewById(R.id.imageButton2);
        // get a reference to the activity hosting this fragment and find the item index num
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        fragAdaptPos = viewPager.getCurrentItem();

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
