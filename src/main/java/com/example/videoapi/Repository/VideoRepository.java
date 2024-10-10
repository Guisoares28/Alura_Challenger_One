package com.example.videoapi.Repository;
import com.example.videoapi.Model.Categoria;
import com.example.videoapi.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByCategoriaId(Long categoriaId);

    List<Video> findByTituloContainingIgnoreCase(String titulo);

}
