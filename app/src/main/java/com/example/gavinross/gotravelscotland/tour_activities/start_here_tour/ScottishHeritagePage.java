package com.example.gavinross.gotravelscotland.tour_activities.start_here_tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.tour_activities.TourActivity;

/**
 * Created by gavinross on 29/03/2018.
 */

public class ScottishHeritagePage extends TourActivity {
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);

        TextView mHeadingTextView = (TextView) findViewById(R.id.heading);
        TextView mParagraphView = (TextView) findViewById(R.id.paragraph);
        ImageButton largePlayButton = (ImageButton)findViewById(R.id.largePlayButton);
        ImageButton nextActivity = (ImageButton) findViewById(R.id.nextSlideButton);


        String videoFilePath = "/mnt/extSdCard/gts_scottish_world_heritage_multi.mp4";
        mHeadingTextView.setText(R.string.scottish_world_heritage_title);
        mParagraphView.setText(R.string.scottish_world_heritage_para);

        VideoView videoView =(VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(videoFilePath);
        VideoView fullscreenVideoView  = (VideoView) findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoFilePath);


        // Pass in the next activity it's going to
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScottishHeritagePage.this, StartHereAdOne.class);
                startActivity(intent);

            }
        });
    }
}