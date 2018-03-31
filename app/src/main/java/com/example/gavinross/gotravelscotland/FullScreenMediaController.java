package com.example.gavinross.gotravelscotland;

/**
 * Created by gavinross on 16/12/2017.
 *
 * Extended class from the android MediaController. Has three constructors. One takes and activity and
 * two videoViews, one takes a getContext() method for use with fragments. And the last is for full
 * screen only.
 */

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.gavinross.gotravelscotland.instructions_page.fragments.VideoFragment;

import java.io.Serializable;

public class FullScreenMediaController extends MediaController {

    private ImageButton fullScreen;
    private boolean isFullScreen = false;
    private int fileId;
    private VideoView fullscreenVideo;
    private VideoView videoView;
    private boolean fullscreenMode;

    public FullScreenMediaController(Context context, VideoView videoView,
                                     VideoView fullscreenVideo) {

        super(context);
        this.fullscreenVideo = fullscreenVideo;
        this.videoView = videoView;
    }

    /**
     * Secondry constructor for use when only a fullscreen video is required. If one videoView is
     * inserted then it will assume you want a full screen video and remove the button by setting
     * the mode to true.
     *
     * @param context
     * @param fullscreenVideo
     */
    public FullScreenMediaController(Context context, VideoView fullscreenVideo) {
        super(context);
        this.fullscreenVideo = fullscreenVideo;

    }

    public FullScreenMediaController(Activity activity, VideoView videoView, VideoView fullscreenVideo) {
        super(activity);
        this.fullscreenVideo = fullscreenVideo;
        this.videoView = videoView;
    }

    @Override
    public void setAnchorView(View view) {

        super.setAnchorView(view);

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
        params.rightMargin = 70;
        params.topMargin = 5;

            //image button for full screen to be added to media controller
            fullScreen = new ImageButton (super.getContext());
            fullScreen.isOpaque();
            fullScreen.setBackgroundColor(getSolidColor());


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
                        int current = fullscreenVideo.getCurrentPosition();
                        fullscreenVideo.pause(); // this is critical for audio overlap in language tracks
                        fullscreenVideo.clearFocus();
                        fullscreenVideo.setVisibility(View.GONE);
                        videoView.setVisibility(View.VISIBLE);

                        videoView.seekTo(current);
                        videoView.start();
                        isFullScreen = false;
                    }else{
                        //fullScreen.setImageResource(R.drawable.ic_fullscreen_white_24dp);
                        int current = videoView.getCurrentPosition();
                        videoView.pause(); // this is critical for audio overlap in language tracks
                        videoView.clearFocus();
                        videoView.setVisibility(View.GONE);
                        fullscreenVideo.setVisibility(View.VISIBLE);

                        fullscreenVideo.seekTo(current);
                        fullscreenVideo.start();
                        isFullScreen = true;
                    }

                }
            });

    }

    public int getFileId() {
        return fileId;
    }


}
