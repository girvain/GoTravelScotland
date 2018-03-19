package com.example.gavinross.gotravelscotland.whats_on_classes;

/**
 * Created by gavin on 18/03/18.
 */

public class Advert {
    private int imageId;
    private String name;
    private String description;

    public Advert(int imageId, String name, String description) {
        this.imageId = imageId;
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    int getImageResourceId() {
        return imageId;
    }
    // fix this !!!
    boolean hasImage() {
        return imageId > 0;
    }
}
