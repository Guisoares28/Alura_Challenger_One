package com.example.videoapi.Controller;
import com.example.videoapi.Model.Video;
import com.example.videoapi.Service.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping
    public ResponseEntity<Video> createdVideo(@Valid @RequestBody Video video){
        return videoService.createdVideo(video);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideo(){
        return videoService.getAllVideo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByid(@PathVariable Long id){
        return videoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedById(@PathVariable Long id){
        return videoService.deletedById(id);
    }


}
