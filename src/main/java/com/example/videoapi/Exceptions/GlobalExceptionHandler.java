package com.example.videoapi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VideoNotFoundException.class)
    public ResponseEntity<VideoNotFoundException> handleVideoNotFoundException(VideoNotFoundException e){
        return new ResponseEntity<>(new VideoNotFoundException("Video não encontrado"), HttpStatus.NOT_FOUND);
    }

}
