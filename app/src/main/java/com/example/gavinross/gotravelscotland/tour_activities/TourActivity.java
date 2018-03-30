package com.example.gavinross.gotravelscotland.tour_activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.FullScreenMediaController;
import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.tour_activities.start_here_tour.EdinburghPage;

import java.util.Locale;

public class TourActivity extends AppCompatActivity{

    private VideoView videoView;
    private FullScreenMediaController mc;

    private String videoFilePath;
    private TextView mHeadingTextView;
    private TextView mParagraphView;
    private VideoView fullscreenVideoView;
    private ImageButton largePlayButton;
    private ImageButton nextActivity;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_slide_page);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        mHeadingTextView = (TextView) findViewById(R.id.heading);
        mParagraphView = (TextView) findViewById(R.id.paragraph);
        largePlayButton = (ImageButton)findViewById(R.id.largePlayButton);
        nextActivity = (ImageButton) findViewById(R.id.nextSlideButton);

        /*
        This is the part that needs override when inheriting this class
         */
        videoFilePath = "android.resource://" + getPackageName() + "/" +
                R.raw.gts_commando_memorial_multi;
        mHeadingTextView.setText(R.string.edinburgh_title);
        mParagraphView.setText(R.string.edinburgh_para);


        videoView =(VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(videoFilePath);
        fullscreenVideoView  = (VideoView) findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoFilePath);
        videoView.seekTo(10000);

        mc = new FullScreenMediaController(this, videoView);
        mc.show(5); // how long controls are displayed

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                /*
                This has been put before the size change listener (which was not actually nessesary)
                so that the getActivity.getSupportActionBar().show() can act first which solves the
                media controller displaying above the video.
                 */

                // This might need to go back in but was causing  a crash!!
                getSupportActionBar().show();

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        fullscreenVideoView.clearFocus();
                        videoView.requestFocus();
                        videoView.setMediaController(mc);
                        mc.setAnchorView(videoView);

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
                getSupportActionBar().hide();


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

        largePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // What this listener used to be exclusively for
                largePlayButton.setVisibility(View.INVISIBLE);
                videoView.seekTo(0);
                videoView.start();

            }
        });

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.clearFocus();
                fullscreenVideoView.clearFocus();

                Intent intent = new Intent(TourActivity.this, EdinburghPage.class);
                startActivity(intent);

            }
        });

    }

    public void onPause() {
        super.onPause();
        videoView.stopPlayback();
        fullscreenVideoView.stopPlayback();
    }


}
