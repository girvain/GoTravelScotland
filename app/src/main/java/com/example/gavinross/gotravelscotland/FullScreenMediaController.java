package com.example.gavinross.gotravelscotland;

/**
 * Created by gavinross on 16/12/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;

import java.io.Serializable;

public class FullScreenMediaController extends MediaController {

    private ImageButton fullScreen;
    private boolean isFullScreen = false;
    private int fileId;
    private VideoView fullscreenVideo;
    private VideoView videoView;

    public FullScreenMediaController(Context context, VideoView videoView,
                                     VideoView fullscreenVideo) {

        super(context);
        this.fullscreenVideo = fullscreenVideo;
        this.videoView = videoView;
    }

    @Override
    public void setAnchorView(View view) {

        super.setAnchorView(view);


        //image button for full screen to be added to media controller
        fullScreen = new ImageButton (super.getContext());
        fullScreen.isOpaque();
        fullScreen.setBackgroundColor(getSolidColor());

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
        params.rightMargin = 80;
        addView(fullScreen, params);
        fullScreen.bringToFront();

        if(isFullScreen){
            fullScreen.setImageResource(R.drawable.ic_fullscreen_exit_white_24dp);

        }else{
            fullScreen.setImageResource(R.drawable.ic_fullscreen_white_24dp);
        }


        //add listener to image button to handle full screen and exit full screen events
        fullScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFullScreen){
                    videoView.stopPlayback();
                    videoView.setVisibility(View.INVISIBLE);
                    fullscreenVideo.setVisibility(View.VISIBLE);
                }else{
                    //fullScreen.setImageResource(R.drawable.ic_fullscreen_white_24dp);
                    videoView.stopPlayback();
                    videoView.setVisibility(View.INVISIBLE);
                    fullscreenVideo.setVisibility(View.VISIBLE);
                    fullscreenVideo.start();

                }



            }
        });
    }

    public int getFileId() {
        return fileId;
    }
}
