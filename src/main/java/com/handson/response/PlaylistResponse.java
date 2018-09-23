package com.handson.response;

import com.handson.domain.Musicas;
import com.handson.domain.Playlists;
import com.handson.domain.Usuarios;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlaylistResponse {

    private String id;

    private UsuarioResponse usuario;

    private List<MusicaResponse> playlistMusicas;

    public String getId() {
        return id;
    }

    public UsuarioResponse getUsuario() {
        return usuario;
    }

    public List<MusicaResponse> getPlaylistMusicas() {
        return playlistMusicas;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private PlaylistResponse dto;

        private Builder() {
            dto = new PlaylistResponse();
        }

        public PlaylistResponse build() {
            return dto;
        }

        public PlaylistResponse.Builder comId(String id) {
            dto.id = id;
            return this;
        }

        public PlaylistResponse.Builder comUsuario(Usuarios usuarios) {
            dto.usuario = new UsuarioResponse();
            dto.usuario.setNome(usuarios.getNome());
            dto.usuario.setId(usuarios.getId());
            dto.usuario.setPlaylistId(usuarios.getPlaylists().getId());
            return this;
        }


        public PlaylistResponse.Builder comPlaylist(Usuarios usuarios) {
            Playlists playlists = usuarios.getPlaylists();
            Set<Musicas> musicas = playlists.getMusicas();
            dto.playlistMusicas =  musicas.stream().map(this::criarMusicaResponse).collect(Collectors.toList());
            return this;
        }

        private MusicaResponse criarMusicaResponse(Musicas musicas) {
            return MusicaResponse.builder()
                    .comId(musicas.getId())
                    .comNome(musicas.getNome())
                    .comArtistaId(musicas.getArtistas().getId())
                    .comArtistas(musicas.getArtistas()).build();
        }

    }

}
