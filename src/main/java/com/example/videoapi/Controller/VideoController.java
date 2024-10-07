package com.example.videoapi.Controller;
import com.example.videoapi.Model.Video;
import com.example.videoapi.Service.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping
    public ResponseEntity<Video> createdVideo(@Valid @RequestBody Video video){
        Video newVideo = videoService.createdVideo(video);
        return ResponseEntity.ok().body(newVideo);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideo(){
        List<Video> videos = videoService.getAllVideo();
        return ResponseEntity.ok().body(videos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByid(@PathVariable Long id){
        Optional<Video> video = videoService.getById(id);
        if(video.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }else{
            return ResponseEntity.ok(video.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedById(@PathVariable Long id){
        Optional<Video> optVideo = videoService.deletedById(id);
        if(optVideo.isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Video excluido com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado para exclusão");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVideo(@PathVariable Long id, @RequestBody Video video){
        Optional<Video> newVideo = videoService.updateVideo(id, video);
        if (newVideo.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(newVideo.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado");
        }
    }


}
