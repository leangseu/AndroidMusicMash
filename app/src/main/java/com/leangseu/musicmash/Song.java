package com.leangseu.musicmash;

/**
 * Created by leangseu on 10/7/17.
 */

public class Song {
    private String title;
    private String author;
    private String image;
    private String link;

    public Song(String[] array) {
        this.title = array[0];
        this.author = array[1];
        this.image = "android.resource://com.leangseu.musicmash/drawable/" + array[2];
        this.link = array[3];
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }
}
