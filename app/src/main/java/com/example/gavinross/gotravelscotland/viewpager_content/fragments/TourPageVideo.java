package com.example.gavinross.gotravelscotland.viewpager_content.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.viewpager_content.FragContainer;

import java.util.Locale;

/**
 * Created by gavinross on 13/12/2017.
 */

public class TourPageVideo extends Fragment{

    private VideoView videoView;
    private FullScreenMediaController mc;
    private View rootView;
    private FragContainer fragContainer;
    private ViewPager viewPager;

    private String headingText; // for holding text from newInstance to bundle
    private String paragraphText; // to then be passed to textViews
    private int videoId;
    private int videoAdId;
    private boolean adPlayed;

    private TextView mHeadingTextView;
    private TextView mParagraphView;
    private VideoView fullscreenVideoView;
    private ImageButton largePlayButton;

    String videoFilePath;
    String videoAdFilePath;


    public static TourPageVideo newInstance(String headingText, String paragraphText, int videoId) {

        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);
        bundle.putString("paragraph", paragraphText);
        bundle.putInt("videoId", videoId);

        TourPageVideo fragment = new TourPageVideo();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static TourPageVideo newInstance(String headingText, String paragraphText, int videoId,
                                            int videoAdId) {

        Bundle bundle = new Bundle();
        bundle.putString("heading", headingText);
        bundle.putString("paragraph", paragraphText);
        bundle.putInt("videoId", videoId);
        bundle.putInt("videoAdId", videoAdId);

        TourPageVideo fragment = new TourPageVideo();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            headingText = bundle.getString("heading");
            paragraphText = bundle.getString("paragraph");
            videoId = bundle.getInt("videoId");
            videoAdId = bundle.getInt("videoAdId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.tour_slide_page, container, false);

        readBundle(getArguments()); // get data from bundle and put it in fields

        videoFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
                videoId;

        videoAdFilePath = "android.resource://" + getActivity().getPackageName() + "/" +
                videoAdId;

        mHeadingTextView = (TextView) rootView.findViewById(R.id.heading);
        mParagraphView = (TextView) rootView.findViewById(R.id.paragraph);
        largePlayButton = (ImageButton)rootView.findViewById(R.id.largePlayButton);
        mHeadingTextView.setText(headingText);
        mParagraphView.setText(paragraphText);
        // ref to the parent activity
        fragContainer = (FragContainer)this.getActivity();


        videoView =(VideoView) rootView.findViewById(R.id.videoView);
        videoView.setVideoPath(videoFilePath);

        fullscreenVideoView  = (VideoView) rootView.findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoAdFilePath);

//        fullscreenVideoView  = (VideoView) rootView.findViewById(R.id.fullscreenVideoView);
//        fullscreenVideoView.setVideoPath(videoFilePath);
//        videoView.seekTo(2000);
//
//        mc = new FullScreenMediaController(getContext(), videoView, fullscreenVideoView);
//        mc.show(5); // how long controls are displayed

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

                        // show the swipe dots
                        fragContainer.findViewById(R.id.indicator).setVisibility(View.VISIBLE);
                        // stops the fake dragging to get the swipe going again if it was stopped
                        if (viewPager.isFakeDragging()) {
                            viewPager.endFakeDrag();
                        }
                    }
                });


                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        MediaPlayer.TrackInfo[] trackInfoArray = mp.getTrackInfo();
                        for (int i = 0; i < trackInfoArray.length; i++) {
                            // you can switch out the language comparison logic to whatever works for you
                            if (trackInfoArray[i].getTrackType() == MediaPlayer.TrackInfo.MEDIA_TRACK_TYPE_AUDIO
                                    && trackInfoArray[i].getLanguage().equals(Locale.getDefault().getISO3Language())) {
                                mp.selectTrack(i);
                                break;
                            }

                        }
                        return true;
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

                        // hides the swipe dots
                        fragContainer.findViewById(R.id.indicator).setVisibility(View.INVISIBLE);
                        // stops the dragging
                        viewPager.beginFakeDrag();
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
                videoView.pause();
            }

            @Override
            public void onPageSelected(int position) {
                if (!adPlayed) {
                    videoView.setVisibility(View.INVISIBLE);
                    fullscreenVideoView.setVisibility(View.VISIBLE);


                    fullscreenVideoView.start();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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


        /*
        COmpletion listener for finishing the advert
         */
        fullscreenVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (!adPlayed) {
                    fullscreenVideoView  = (VideoView) rootView.findViewById(R.id.fullscreenVideoView);
                    fullscreenVideoView.setVideoPath(videoFilePath);
                    videoView.seekTo(2000);

                    mc = new FullScreenMediaController(getContext(), videoView, fullscreenVideoView);
                    mc.show(5); // how long controls are displayed
                }
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



        fullscreenVideoView.start();

        return rootView;
    }
}
