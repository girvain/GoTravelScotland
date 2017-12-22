package com.example.gavinross.gotravelscotland.tours.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.R;

/**
 * Created by gavinross on 13/12/2017.
 */

public class TourPageVideo extends Fragment{

    private VideoView videoView;
    private FullScreenMediaController mc;
    private View rootView;

    private String headingText; // for holding text from newInstance to bundle
    private String paragraphText; // to then be passed to textViews
    private int resId;

    private TextView mHeadingTextView;
    private TextView mParagraphView;
    private VideoView fullscreenVideoView;
    private ImageButton largePlayButton;

    public static TourPageVideo newInstance(String headingText, String paragraphText, int resId) {

        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);
        bundle.putString("paragraph", paragraphText);
        bundle.putInt("resId", resId);

        TourPageVideo fragment = new TourPageVideo();
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


        View rootView = inflater.inflate(R.layout.tour_silde_page, container, false);

        readBundle(getArguments()); // get data from bundle and put it in fields

        String videoFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
                resId;

        mHeadingTextView = (TextView) rootView.findViewById(R.id.heading);
        mParagraphView = (TextView) rootView.findViewById(R.id.paragraph);
        largePlayButton = (ImageButton)rootView.findViewById(R.id.largePlayButton);
        mHeadingTextView.setText(headingText);
        mParagraphView.setText(paragraphText);


        videoView =(VideoView) rootView.findViewById(R.id.videoView);
        videoView.setVideoPath(videoFilePath);
        fullscreenVideoView  = (VideoView) rootView.findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoFilePath);
        videoView.seekTo(2000);

        mc = new FullScreenMediaController(getContext(), videoView, fullscreenVideoView);
        mc.show(5); // how long controls are displayed

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                /*
                This has been put before the size change listener (which was not actually nessesary)
                so that the getActivity.getSupportActionBar().show() can act first which solves the
                media controller displaying above the video.
                 */
                ((AppCompatActivity) getActivity()).getSupportActionBar().show();
                //mc = new FullScreenMediaController(getContext(), videoView, fullscreenVideoView);

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        fullscreenVideoView.clearFocus();
                        videoView.requestFocus();
                        videoView.setMediaController(mc);
                        mc.setAnchorView(videoView);
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
                    }
                });
            }
        });


        // get a reference to the activity hosting this fragment and find the item index num
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        //fragAdaptPos = viewPager.getCurrentItem();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mc != null) {
                    mc.hide();
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                videoView.pause();
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



//        videoView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (videoView.isPlaying()) {
//                    videoView.pause();
//                }
//                else if (!videoView.hasFocus()) {
//                    videoView.pause();
//                }
//                else if (!videoView.isShown()){
//                    videoView.pause();
//                }
//                else
//                    videoView.start();
//
//                return false;
//            }
//        });

        return rootView;
    }
}
