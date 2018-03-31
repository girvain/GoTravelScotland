package com.example.gavinross.gotravelscotland.tour_activities.highlands_and_lochs_tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.R;
import com.example.gavinross.gotravelscotland.tour_activities.TourActivity;
import com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour.BlairAthollPage;
import com.example.gavinross.gotravelscotland.tour_activities.towards_loch_ness_tour.CairngormsPage;

public class TheTrossachsPage extends TourActivity {
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);

        TextView mHeadingTextView = (TextView) findViewById(R.id.heading);
        TextView mParagraphView = (TextView) findViewById(R.id.paragraph);
        ImageButton largePlayButton = (ImageButton)findViewById(R.id.largePlayButton);
        ImageButton nextActivity = (ImageButton) findViewById(R.id.nextSlideButton);

        String videoFilePath = "/mnt/extSdCard/gts_the_trossachs_multi.mp4";
        mHeadingTextView.setText(R.string.the_trossachs_title);
        mParagraphView.setText(R.string.the_trossachs_para);

        VideoView videoView =(VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(videoFilePath);
        VideoView fullscreenVideoView  = (VideoView) findViewById(R.id.fullscreenVideoView);
        fullscreenVideoView.setVideoPath(videoFilePath);
        videoView.seekTo(10000);

        // Pass in the next activity it's going to
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TheTrossachsPage.this, CallanderPage.class);
                startActivity(intent);

            }
        });
    }
}
