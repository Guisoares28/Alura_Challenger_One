package com.example.videoapi.Service;

import com.example.videoapi.Exceptions.Excecoes;
import com.example.videoapi.Model.Video;
import com.example.videoapi.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public ResponseEntity<Video> createdVideo(Video video){
        videoRepository.save(video);
        return new ResponseEntity<>(video, HttpStatus.CREATED);
    }


    public ResponseEntity<List<Video>> getAllVideo() {
        List<Video> videos = videoRepository.findAll();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }


    public ResponseEntity<?> getById(Long id) {
        Optional<Video> optVideo = videoRepository.findById(id);
        if(optVideo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Excecoes("Não encontrado"));
        }else{
            return new ResponseEntity<>(optVideo.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deletedById(Long id) {
        Optional<Video> optVideo = videoRepository.findById(id);
        if (optVideo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Excecoes("Falha ao deletar o Video"));
        }else{
            videoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Excecoes("Video deletado com sucesso!"));
        }

    }

}
