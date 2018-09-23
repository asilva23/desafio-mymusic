package com.handson.repository;

import com.handson.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistsRepository extends JpaRepository<Usuarios, String> {

    @Query("select u from Usuarios u where u.nome = ?1")
    Usuarios buscarPorUsuario(String user);
}
