package com.handson.controller;

import com.handson.response.MusicaResponse;
import com.handson.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicasController {

    @Autowired
    private MusicaService musicaService;

    @RequestMapping(value = "/api/musicas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MusicaResponse>> getMusicas(@RequestParam(value = "filtro", required = false) String filtro) {

        if(filtro != null && filtro.length() < 3) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<MusicaResponse> response = musicaService.buscarMusicasPorFiltro(filtro);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
