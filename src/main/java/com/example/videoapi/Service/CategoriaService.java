package com.example.videoapi.Service;

import com.example.videoapi.Model.Categoria;
import com.example.videoapi.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria createVideo(Categoria categoria) {
        categoriaRepository.save(categoria);
        return categoria;
    }

    public List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getByIdCategoria(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria;
    }

    public Optional<Categoria> updateCategoria(Long id, Categoria categoria){
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id);
        if(categoriaEncontrada.isPresent()){
            categoria.setId(id);
            categoriaRepository.save(categoria);
        }
        return categoriaEncontrada;
    }

    public Optional<Categoria> deleteById(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()){
            categoriaRepository.deleteById(id);
        }
        return categoria;
    }
}