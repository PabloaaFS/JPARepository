package com.futurespace.JPAProject.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "editoriales")
public class Editoriales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EditorialID")
    private int editorialId;

    @Column(name = "Editorial")
    private String editorial;

    @Column(name = "RazonSocial")
    private String razonSocial;

    // Getters y setters

    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}

