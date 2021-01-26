package com.qa.choonz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.choonz.exception.TrackNotFoundException;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.repository.TrackRepository;
import com.qa.choonz.rest.dto.TrackDTO;
import com.qa.choonz.utils.BeanUtils;

@Service
public class TrackService {

    private TrackRepository repo;
    private ModelMapper mapper;

    private TrackDTO mapToDTO(Track track) {
        return this.mapper.map(track, TrackDTO.class);
    }
    
    @Autowired
    public TrackService(TrackRepository repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }


    public TrackDTO create(Track track) {
        Track created = this.repo.save(track);
        return this.mapToDTO(created);
    }

    public List<TrackDTO> readAll() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public TrackDTO readOne(long id) {
        Track found = this.repo.findById(id).orElseThrow(TrackNotFoundException::new);
        return this.mapToDTO(found);
    }

    public TrackDTO update(TrackDTO trackDTO, long id) {
        Track toUpdate = this.repo.findById(id).orElseThrow(TrackNotFoundException::new);
        toUpdate.setName(trackDTO.getName());
        toUpdate.setAlbum(trackDTO.getAlbum());
        toUpdate.setDuration(trackDTO.getDuration());
        toUpdate.setLyrics(trackDTO.getLyrics());
        toUpdate.setPlaylist(trackDTO.getPlaylist());
        BeanUtils.mergeNotNull(trackDTO, toUpdate);
        Track updated = this.repo.save(toUpdate);
        return this.mapToDTO(updated);
    }

    public boolean delete(long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

}
