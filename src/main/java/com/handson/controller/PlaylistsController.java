package com.handson.controller;

import com.handson.domain.Usuarios;
import com.handson.repository.PlaylistsRepository;
import com.handson.response.PlaylistResponse;
import com.handson.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistsController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private PlaylistsRepository playlistsRepository;


    @RequestMapping(value = "/api/playlists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PlaylistResponse> getPlayListPorUsuario(@RequestParam(value = "user", required = true) String user) {

        Usuarios usuario = playlistsRepository.buscarPorUsuario(user);

        if(usuario == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        PlaylistResponse response = playlistService.buscarPlaylistPorUsuario(usuario);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
