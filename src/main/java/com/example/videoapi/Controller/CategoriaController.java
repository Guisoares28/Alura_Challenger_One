package com.example.videoapi.Controller;

import com.example.videoapi.Model.Categoria;
import com.example.videoapi.Service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria categoria){
        categoriaService.createVideo(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAllCategoria(){
        List<Categoria> categorias = categoriaService.getAllCategoria();
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = categoriaService.getByIdCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@Valid @PathVariable Long id, @RequestBody Categoria categoria){
        Categoria categoriaAtualizada = categoriaService.updateCategoria(id, categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Video deletado com sucesso!");
    }



}
