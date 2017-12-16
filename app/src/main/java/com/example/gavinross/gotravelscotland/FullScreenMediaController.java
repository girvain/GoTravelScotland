package com.example.gavinross.gotravelscotland;

/**
 * Created by gavinross on 16/12/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

public class FullScreenMediaController extends MediaController {

    private ImageButton fullScreen;
    private String isFullScreen;
    private int fileId;


    public FullScreenMediaController(Context context, int fileId) {
        super(context);
        this.fileId = fileId;
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

        //fullscreen indicator from intent
        isFullScreen =  ((Activity)getContext()).getIntent().
                getStringExtra("fullScreenInd");

        if("y".equals(isFullScreen)){
            fullScreen.setImageResource(R.drawable.ic_fullscreen_exit_white_24dp);
        }else{
            fullScreen.setImageResource(R.drawable.ic_fullscreen_exit_white_24dp);
        }

        //add listener to image button to handle full screen and exit full screen events
        fullScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),FullScreenVideoActivity.class);

                // put the file id in the intent  and pass to fullscreenVideoActivity
                intent.putExtra("fileId", fileId);

                if("y".equals(isFullScreen)){
                    intent.putExtra("fullScreenInd", "");
                }else{
                    intent.putExtra("fullScreenInd", "y");
                }
                ((Activity)getContext()).startActivity(intent);
            }
        });
    }

    public int getFileId() {
        return fileId;
    }
}
