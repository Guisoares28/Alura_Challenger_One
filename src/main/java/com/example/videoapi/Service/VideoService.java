package com.example.videoapi.Service;

import com.example.videoapi.Exceptions.VideoNotFoundException;
import com.example.videoapi.Model.Categoria;
import com.example.videoapi.Model.Video;
import com.example.videoapi.Repository.CategoriaRepository;
import com.example.videoapi.Repository.VideoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class VideoService {

    private final VideoRepository videoRepository;

    private final CategoriaRepository categoriaRepository;



    public VideoService(CategoriaRepository categoriaRepository, VideoRepository videoRepository){
        this.categoriaRepository = categoriaRepository;
        this.videoRepository = videoRepository;
    }


    public Video createdVideo(Video video){
        Optional<Categoria> categoria = categoriaRepository.findById(video.getIdCategoria());
        if(categoria.isPresent()){
            video.setCategoria(categoria.get());
        }else{
            Optional<Categoria> categoria_id = categoriaRepository.findById(1L);
            video.setCategoria(categoria_id.get());
        }
        videoRepository.save(video);
        return video;
    }


    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }


    public Video getById(Long id) {
        return videoRepository.findById(id).orElseThrow(VideoNotFoundException::new);
    }

    public Video deletedById(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(VideoNotFoundException::new);
        videoRepository.deleteById(id);
        return video;
    }

    public Video updateVideo(Long id, Video video) {
        Video videoEncontrado = videoRepository.findById(id)
                .orElseThrow(VideoNotFoundException::new);
        boolean categoriaExiste = categoriaRepository.existsById(video.getIdCategoria());
        if (categoriaExiste){
            Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(video.getIdCategoria());
            video.setCategoria(categoriaEncontrada.get());

        }else{
            Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(1L);
            video.setCategoria(categoriaEncontrada.get());
        }
        videoEncontrado.setTitulo(video.getTitulo());
        videoEncontrado.setDescricao(video.getDescricao());
        videoEncontrado.setUrl(video.getUrl());
        videoEncontrado.setCategoria(video.getCategoria());
        videoRepository.save(videoEncontrado);
        return videoEncontrado;
    }

    public List<Video> getVideoByCategoria(Long categoriaId){
        return videoRepository.findByCategoriaId(categoriaId);
    }

    public List<Video> getVideoByTitulo(String titulo){
        return videoRepository.findByTituloContainingIgnoreCase(titulo);
    }


}
