package com.example.videoapi.Service;

import com.example.videoapi.Exceptions.VideoNotFoundException;
import com.example.videoapi.Model.Categoria;
import com.example.videoapi.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoriaService {

    CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria createVideo(Categoria categoria) {
        categoriaRepository.save(categoria);
        return categoria;
    }

    public List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }

    public Categoria getByIdCategoria(Long id){
        return categoriaRepository.findById(id).orElseThrow(VideoNotFoundException::new);
    }

    public Categoria updateCategoria(Long id, Categoria categoria){
        Categoria categoriaEncontrada = categoriaRepository.findById(id).orElseThrow(VideoNotFoundException::new);
        categoriaEncontrada.setTitulo(categoria.getTitulo());
        categoriaEncontrada.setCor(categoria.getCor());
        categoriaRepository.save(categoriaEncontrada);
        return categoriaEncontrada;
    }

    public Categoria deleteById(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(VideoNotFoundException::new);
        categoriaRepository.deleteById(id);
        return categoria;
    }

}