package com.futurespace.JPAProject.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tematicas")
public class Tematicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TematicaID")
    private int tematicaId;

    @Column(name = "Categoria")
    private String categoria;

    // Getters y setters

    public int getTematicaId() {
        return tematicaId;
    }

    public void setTematicaId(int tematicaId) {
        this.tematicaId = tematicaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

