package com.handson.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "PlaylistMusicas",
            joinColumns = { @JoinColumn(name = "PlaylistId") },
            inverseJoinColumns = { @JoinColumn(name = "MusicaId") }
    )
    Set<Musicas> musicas = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Musicas> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<Musicas> musicas) {
        this.musicas = musicas;
    }
}
