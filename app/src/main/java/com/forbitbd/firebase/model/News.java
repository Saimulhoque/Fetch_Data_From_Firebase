package com.forbitbd.firebase.model;

public class News {

    String title;
    String videourl;
    String imgurl;

    public News() {
    }

    public News(String title, String videourl, String imgurl) {
        this.title = title;
        this.videourl = videourl;
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
