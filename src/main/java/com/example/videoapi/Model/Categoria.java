package com.example.videoapi.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String titulo;

    @NotBlank
    String cor;

    @OneToMany(mappedBy = "categoria")
    private List<Video> videos;

    public Categoria() {
    }

    public Categoria(Long id, String titulo, String cor) {
        this.id = id;
        this.titulo = titulo;
        this.cor = cor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
