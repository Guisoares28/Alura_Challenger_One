package com.example.videoapi.Service;


import com.example.videoapi.Exceptions.VideoNotFoundException;
import com.example.videoapi.Model.Video;
import com.example.videoapi.Repository.VideoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }

    public Video createdVideo(Video video){
        videoRepository.save(video);
        return video;
    }


    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }


    public Video getById(Long id) {
        return videoRepository.findById(id).orElseThrow(() -> new VideoNotFoundException("Não encontrado"));
    }

    public Video deletedById(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new VideoNotFoundException("Video não encontrado"));
        videoRepository.deleteById(id);
        return video;
    }

    public Video updateVideo(Long id, Video video) {
        Video videoEncontrado = videoRepository.findById(id)
                .orElseThrow(() -> new VideoNotFoundException("Video não encontrado"));
        videoEncontrado.setTitulo(video.getTitulo());
        videoEncontrado.setDescricao(video.getDescricao());
        videoEncontrado.setUrl(video.getUrl());
        videoEncontrado.setCategoria(video.getCategoria());
        videoRepository.save(videoEncontrado);
        return videoEncontrado;

    }

}
