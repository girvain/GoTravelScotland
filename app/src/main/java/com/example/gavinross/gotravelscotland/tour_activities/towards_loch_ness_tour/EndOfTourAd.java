package com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.TourHomePage;
import com.example.gavinross.gotravelscotland.tour_activities.start_here_tour.AdvertPage;

public class EndOfTourAd extends AppCompatActivity {
    private VideoView fullscreenVideoView;
    private Button nextPartButton;
    private boolean adPlayed;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_slide_ad);
        // sets the actionBar up
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_layout);

        /*
        OVERRIDE SECTION FOR MAKING THE ADS
        ALSO MUST OVERRIDE THE LISTENER FOR NextPartButton
         */
        final String videoFilePath = "android.resource://" + getPackageName() + "/" +
                R.raw.intro_tour;
        nextPartButton = (Button) findViewById(R.id.startPartTwoButton);
        nextPartButton.setText(R.string.start_next_tour_button_text);
        fullscreenVideoView = (VideoView) findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoFilePath);
        //videoView.seekTo(2000);


        fullscreenVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // remove the action bar!!!
                getSupportActionBar().hide();
                if (!adPlayed) { // Start the av only if its not been played in this lifecycle
                    fullscreenVideoView.start();
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        fullscreenVideoView.setVisibility(View.INVISIBLE);
                        adPlayed = true; // set state to true coz ad is now played
                        nextPartButton.setVisibility(View.VISIBLE); //show button after video

                        // This is what broke it i think
                        fullscreenVideoView.clearFocus();

                        // show the action bar again
                        getSupportActionBar().show();

                    }
                });
            }
        });

        // This sets the visability of video and button after the ad has played
        fullscreenVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                nextPartButton.setVisibility(View.VISIBLE); // hide video
                fullscreenVideoView.setVisibility(View.INVISIBLE); // show the button
            }
        });


        // Take user back to the start of tour selection
        nextPartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndOfTourAd.this, TourHomePage.class);
                startActivity(intent);
            }
        });

    }
}
