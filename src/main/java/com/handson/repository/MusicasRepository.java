package com.handson.repository;

import com.handson.domain.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicasRepository extends JpaRepository<Musicas, String> {

    @Query("select m from Musicas m where m.nome like %?1% or m.artistas.nome like %?1% order by m.artistas.nome, m.nome")
    List<Musicas> buscarMusicas(String filtro);
}
