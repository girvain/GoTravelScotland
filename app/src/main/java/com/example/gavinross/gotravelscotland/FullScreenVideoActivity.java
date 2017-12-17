package com.example.gavinross.gotravelscotland;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.instructions_page.InstructionsPage;
import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;

public class FullScreenVideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private int assignedVideoName;
    private int videoPosition;
    private int fragAdaptPos;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscreen_videoview);

        assignedVideoName = getIntent().getIntExtra("fileId",0);
        videoPosition = getIntent().getIntExtra("videoPosition", 0);
        fragAdaptPos = getIntent().getIntExtra("fragAdaptPos", 0);

        videoView = (VideoView)findViewById(R.id.videoView);


        String fullScreen =  getIntent().getStringExtra("fullScreenInd");
        if("y".equals(fullScreen)){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        }


                Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+assignedVideoName);

        videoView.setVideoURI(videoUri);

        ImageButton fullscreenButton = (ImageButton) findViewById(R.id.imageButton);
        intent = new Intent(this, InstructionsPage.class);

        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("fragAdaptPos", fragAdaptPos);
                intent.putExtra("videoPosition", videoView.getCurrentPosition());
                startActivity(intent);
                //finish();
            }
        });

        // make a new object and pass it the video file
        mediaController = new FullScreenMediaController(this, assignedVideoName);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.seekTo(videoPosition);
        videoView.start();
    }
}
