package com.example.videoapi.Controller;


import com.example.videoapi.Model.Categoria;
import com.example.videoapi.Service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria categoria){
        categoriaService.createVideo(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAllCategoria(){
        List<Categoria> categorias = categoriaService.getAllCategoria();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Categoria> categoria = categoriaService.getByIdCategoria(id);
        if (categoria.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(categoria);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
       Optional<Categoria> categoriaAntiga = categoriaService.updateCategoria(id, categoria);
        if (categoriaAntiga.isPresent()){
            return ResponseEntity.status((HttpStatus.OK)).body(categoria);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria informada não encontrada");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<Categoria> categoria = categoriaService.deleteById(id);
        if (categoria.isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoria.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
        }
    }



}
