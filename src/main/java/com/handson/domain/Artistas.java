package com.handson.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artistas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private  String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistas")
    private List<Musicas> musicas;

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

    public List<Musicas> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musicas> musicas) {
        this.musicas = musicas;
    }
}
