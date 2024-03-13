package com.futurespace.JPAProject.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "AnioPublicacion")
    private int anioPublicacion;

    @ManyToOne
    @JoinColumn(name = "AutorID")
    private Autores autor;

    @ManyToOne
    @JoinColumn(name = "EditorialID")
    private Editoriales editorial;

    @ManyToOne
    @JoinColumn(name = "TematicaID")
    private Tematicas tematica;

    // Getters y setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autorId) {
        this.autor = autorId;
    }

    public Editoriales getEditorial() {
        return editorial;
    }

    public void setEditorial(Editoriales editorial) {
        this.editorial = editorial;
    }

    public Tematicas getTematica() {
        return tematica;
    }

    public void setTematica(Tematicas tematica) {
        this.tematica = tematica;
    }
}

