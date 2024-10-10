package com.example.videoapi.Response;

import com.example.videoapi.Model.Video;

public class VideoResponse {

    private Video video;
    private String message;

    public VideoResponse(Video video, String message){
        this.video = video;
        this.message = message;
    }

    public VideoResponse() {

    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
