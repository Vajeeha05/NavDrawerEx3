package com.example.jiji.navdrawerex3;

/**
 * Created by Jiji on 3/8/2017.
 */

public class ImageClass {

    public ImageClass(String title, String imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public ImageClass() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    private String title;
    private String imageId;
}
