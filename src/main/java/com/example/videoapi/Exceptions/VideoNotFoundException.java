package com.example.videoapi.Exceptions;

public class VideoNotFoundException extends RuntimeException {

    public VideoNotFoundException(String message){
        super(message);
    }
}
