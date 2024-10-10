package com.example.videoapi.Controller;
import com.example.videoapi.Exceptions.VideoNotFoundException;
import com.example.videoapi.Model.Video;
import com.example.videoapi.Service.VideoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping()
public class VideoController {


    VideoService videoService;

    public VideoController(VideoService videoService){
        this.videoService = videoService;
    }


    @PostMapping("/video")
    public ResponseEntity<Video> createdVideo(@Valid @RequestBody Video video){
        videoService.createdVideo(video);
        return ResponseEntity.status(HttpStatus.OK).body(video);
    }

    @GetMapping("/video")
    public ResponseEntity<List<Video>> getAllVideo(){
        List<Video> listaVideo = videoService.getAllVideo();
        return ResponseEntity.status(HttpStatus.OK).body(listaVideo);
    }

    @GetMapping("/video/{id}")
    public ResponseEntity<Video> getByid(@PathVariable Long id){
        Video video = videoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(video);

    }

    @DeleteMapping("/video/{id}")
    public ResponseEntity<String> deletedById(@PathVariable Long id){
        Video videoDeletado = videoService.deletedById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Video deletado com sucesso");

    }

    @PutMapping("/video/{id}")
    public ResponseEntity<Video> updateVideo(@Valid @PathVariable Long id, @RequestBody Video video){
        Video videoAtualizado = videoService.updateVideo(id, video);
        return ResponseEntity.status(HttpStatus.OK).body(videoAtualizado);

    }

    @GetMapping("/categoria/{id}/video/")
    public ResponseEntity<List<Video>> findVideoByCategoriaId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(videoService.getVideoByCategoria(id));
    }

    @GetMapping("/video/")
    public  ResponseEntity<List<Video>> findVideoByTitutlo(@RequestParam(required = false) String titulo){
        if(titulo == null || titulo.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
        }
        List<Video> videos = videoService.getVideoByTitulo(titulo);
        return ResponseEntity.status(HttpStatus.OK).body(videos);
    }

}
