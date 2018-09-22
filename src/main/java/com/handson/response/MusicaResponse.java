package com.handson.response;

import com.handson.domain.Artistas;

public class MusicaResponse {

    private String id;

    private String nome;

    private String artistaId;

    private ArtistaResponse artista;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getArtistaId() {
        return artistaId;
    }

    public ArtistaResponse getArtista() {
        return artista;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private MusicaResponse dto;

        private Builder() {
            dto = new MusicaResponse();
        }

        public Builder comId(String id) {
            dto.id = id;
            return this;
        }

        public Builder comNome(String nome) {
            dto.nome = nome;
            return this;
        }

        public Builder comArtistaId(String artistaId) {
            dto.artistaId = artistaId;
            return this;
        }

        public Builder comArtistas(Artistas artistas) {
            dto.artista = new ArtistaResponse();
            dto.artista.setNome(artistas.getNome());
            dto.artista.setId(artistas.getId());
            return this;
        }

        public MusicaResponse build() {
            return dto;
        }

    }
}
