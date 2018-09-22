package com.handson.service;

import com.handson.response.MusicaResponse;

import java.util.List;

public interface MusicaService {

    List<MusicaResponse> buscarMusicasPorFiltro(String filtro);

}
