package com.handson.service;

import com.handson.domain.Usuarios;
import com.handson.response.PlaylistResponse;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Override
    public PlaylistResponse buscarPlaylistPorUsuario(Usuarios usuario) {
        return criarPlaylist(usuario);
    }

    private PlaylistResponse criarPlaylist(Usuarios usuarios) {
        return PlaylistResponse.builder()
                .comId(usuarios.getPlaylists().getId())
                .comUsuario(usuarios)
                .comPlaylist(usuarios)
                .build();
    }

}
