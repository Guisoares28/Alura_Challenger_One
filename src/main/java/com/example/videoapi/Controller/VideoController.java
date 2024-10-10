package com.example.videoapi.Controller;
import com.example.videoapi.Exceptions.VideoNotFoundException;
import com.example.videoapi.Model.Video;
import com.example.videoapi.Service.VideoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/video")
public class VideoController {


    VideoService videoService;

    public VideoController(VideoService videoService){
        this.videoService = videoService;
    }


    @PostMapping
    public ResponseEntity<Video> createdVideo(@Valid @RequestBody Video video){
        videoService.createdVideo(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideo(){
        List<Video> listaVideo = videoService.getAllVideo();
        return new ResponseEntity<>(listaVideo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getByid(@PathVariable Long id){
        Video video = videoService.getById(id);
        return new ResponseEntity<>(video, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> deletedById(@PathVariable Long id){
        try{
            Video videoDeletado = videoService.deletedById(id);
            return new  ResponseEntity<>(videoDeletado, HttpStatus.NO_CONTENT);
        }catch (VideoNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(@Valid @PathVariable Long id, @RequestBody Video video){
        try{
            Video videoAtualizado = videoService.updateVideo(id, video);
            return new ResponseEntity<>(videoAtualizado, HttpStatus.OK);
        }catch (VideoNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
