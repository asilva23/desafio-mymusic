package com.handson.service;

import com.handson.domain.Usuarios;
import com.handson.response.PlaylistResponse;

public interface PlaylistService {

    PlaylistResponse buscarPlaylistPorUsuario(Usuarios usuario);

}
