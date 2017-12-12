package com.example.gavinross.gotravelscotland;

/**
 * Created by gavinross on 12/12/2017.
 * This is a container to hold data for the messageFragment objects to use. These
 * will most likely be strings or videos.
 */

public class MessageData {

    private String message;

    public MessageData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
