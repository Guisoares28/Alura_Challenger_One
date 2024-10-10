package com.example.videoapi.Exceptions;

public class VideoNotFoundException extends RuntimeException {

    public VideoNotFoundException(){
        super("Video Not Found");
    }
}
