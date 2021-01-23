package com.qa.choonz.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.rest.dto.PlaylistDTO;
import com.qa.choonz.service.PlaylistService;

@RestController
@CrossOrigin
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistService service;

    public PlaylistController(PlaylistService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<PlaylistDTO> create(@RequestBody Playlist playlist) {
        return new ResponseEntity<PlaylistDTO>(this.service.create(playlist), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<PlaylistDTO>> readAll() {
        return new ResponseEntity<List<PlaylistDTO>>(this.service.readAll(), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<PlaylistDTO> readOne(@PathVariable long id) {
        return new ResponseEntity<PlaylistDTO>(this.service.readOne(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlaylistDTO> update(@RequestBody PlaylistDTO playlistDTO, @PathVariable long id) {
        return new ResponseEntity<PlaylistDTO>(this.service.update(playlistDTO, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PlaylistDTO> delete(@PathVariable long id) {
        return this.service.delete(id) ? new ResponseEntity<PlaylistDTO>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<PlaylistDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
