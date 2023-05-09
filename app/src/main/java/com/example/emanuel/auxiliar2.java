package com.example.emanuel;

import android.widget.ImageView;

public class auxiliar2 {

    int image;

    String clicks;
    String time;

    public auxiliar2(int image, String clicks, String time) {
        this.image = image;
        this.clicks = clicks;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
