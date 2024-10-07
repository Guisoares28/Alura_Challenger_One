package com.example.videoapi.Service;


import com.example.videoapi.Model.Video;
import com.example.videoapi.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public Video createdVideo(Video video){
        videoRepository.save(video);
        return video;
    }


    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }


    public Optional<Video> getById(Long id) {
        return videoRepository.findById(id);
    }

    public Optional<Video> deletedById(Long id) {
        Optional<Video> optVideo = videoRepository.findById(id);
        if (optVideo.isPresent()) {
            videoRepository.deleteById(id);
        }
        return optVideo;
    }

    public Optional<Video> updateVideo(Long id, Video video) {
        Optional<Video> videoEncontrado = videoRepository.findById(id);
        if (videoEncontrado.isPresent()) {
            video.setId(id);
            Video updatedVideo = videoRepository.save(video);
        }
        return videoEncontrado;
    }

}
