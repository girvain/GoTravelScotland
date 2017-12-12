package com.example.gavinross.gotravelscotland;

/**
 * Created by gavinross on 12/12/2017.
 * This is a container to hold data for the messageFragment objects to use. These
 * will most likely be strings or videos.
 */

public class MessageData {

    private String message;
    private String videoFilePath;
    private boolean isVideo = false;



    // getters and the is video set and get

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVideoFilePath() {
        return videoFilePath;
    }

    // this method will set isVideo to true as it's the only on that will make it true
    public void setVideoFilePath(String videoFilePath, boolean isVideo) {
        this.videoFilePath = videoFilePath;
        this.isVideo = true;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}
