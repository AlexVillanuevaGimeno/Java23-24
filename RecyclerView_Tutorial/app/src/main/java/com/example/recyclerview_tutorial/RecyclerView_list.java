package com.example.recyclerview_tutorial;

import android.content.Intent;

public class RecyclerView_list {
    Integer image;
    String text;

    public RecyclerView_list(Integer image, String text) {
        this.image = image;
        this.text = text;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
