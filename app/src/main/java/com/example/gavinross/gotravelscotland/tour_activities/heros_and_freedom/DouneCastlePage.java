package com.example.gavinross.gotravelscotland.tour_activities.heros_and_freedom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.tour_activities.TourActivity;
import com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour.CairngormsPage;
import com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour.LochLagganPage;

public class DouneCastlePage extends TourActivity {
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);

        TextView mHeadingTextView = (TextView) findViewById(R.id.heading);
        TextView mParagraphView = (TextView) findViewById(R.id.paragraph);
        ImageButton largePlayButton = (ImageButton)findViewById(R.id.largePlayButton);
        ImageButton nextActivity = (ImageButton) findViewById(R.id.nextSlideButton);

        String videoFilePath = "/mnt/extSdCard/gts_doune_castle_multi.mp4";
        mHeadingTextView.setText(R.string.doune_castle_title);
        mParagraphView.setText(R.string.doune_castle_para);

        VideoView videoView =(VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(videoFilePath);
        VideoView fullscreenVideoView  = (VideoView) findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoFilePath);
        videoView.seekTo(10000);

        // Pass in the next activity it's going to
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DouneCastlePage.this, RobRoyPage.class);
                startActivity(intent);

            }
        });
    }
}
