package com.example.videoapi.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "Videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(name = "titulo")
    String titulo;

    @NotBlank
    @Column(name = "descricao")
    String descricao;

    @NotBlank
    @Column(name = "url")
    String url;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @NotBlank
    private Categoria categoria;

    public Video() {
    }

    public Video(String titulo, String descricao, String url, Categoria categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
