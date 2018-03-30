package com.example.gavinross.gotravelscotland.custom_array_adapter_content;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by gavin on 18/03/18.
 */

public class BasicItem extends AppCompatActivity{
    private int imageId;
    private int name;
    private int description;
    private boolean activity = false;

    public BasicItem(int imageId, int name, int description) {
        this.imageId = imageId;
        this.name = name;
        this.description = description;
    }

//    // set theActivity to true if the object will be used with an activity
//    public BasicItem(int imageId, String name, String description, boolean theActivity) {
//        this.imageId = imageId;
//        this.name = name;
//        this.description = description;
//        this.activity = theActivity;
//    }

    // Method to start the activity that has been passed into the object
    public void customStartActivity() {

    }


    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageId;
    }
    // fix this !!!
    public boolean hasImage() {
        return imageId > 0;
    }

    // check if the object has an activity to launch
    public boolean hasActivity() {
        return activity;
    }
}
