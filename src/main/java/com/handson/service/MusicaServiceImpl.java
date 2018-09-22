package com.handson.service;

import com.handson.domain.Musicas;
import com.handson.repository.MusicasRepository;
import com.handson.response.MusicaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicasRepository musicasRepository;

    @Override
    public List<MusicaResponse> buscarMusicasPorFiltro(String filtro) {
        List<Musicas> musicas = musicasRepository.buscarMusicas(filtro);
        return musicas.stream().map(this::criarMusicaResponse).collect(Collectors.toList());
    }

    private MusicaResponse criarMusicaResponse(Musicas musicas) {
        return MusicaResponse.builder()
                .comId(musicas.getId())
                .comNome(musicas.getNome())
                .comArtistaId(musicas.getArtistas().getId())
                .comArtistas(musicas.getArtistas()).build();
    }

}
