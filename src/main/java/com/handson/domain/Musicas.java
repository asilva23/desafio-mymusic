package com.handson.domain;

import javax.persistence.*;

@Entity
@Table(name = "musicas")
public class Musicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private  String nome;

    @ManyToOne
    @JoinColumn(name = "ArtistaId")
    private Artistas artistas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artistas getArtistas() {
        return artistas;
    }

    public void setArtistas(Artistas artistas) {
        this.artistas = artistas;
    }
}
