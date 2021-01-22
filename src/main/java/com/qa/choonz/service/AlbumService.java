package com.qa.choonz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.choonz.exception.AlbumNotFoundException;
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.repository.AlbumRepository;
import com.qa.choonz.rest.dto.AlbumDTO;
import com.qa.choonz.utils.BeanUtils;

@Service
public class AlbumService {

	private AlbumRepository repo;
	private ModelMapper mapper;

	private AlbumDTO mapToDTO(Album album) {
		return this.mapper.map(album, AlbumDTO.class);
	}

	@Autowired
	public AlbumService(AlbumRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// Create - Retrun DTO
	public AlbumDTO create(Album album) {
		Album created = this.repo.save(album);
		return this.mapToDTO(created);
	}

	// Read all
	public List<AlbumDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Read one
	public AlbumDTO readOne(Long id) {
		Album found = this.repo.findById(id).orElseThrow(AlbumNotFoundException::new);
		return this.mapToDTO(found);
	}

	// Update
	public AlbumDTO update(AlbumDTO album, Long id) {
		Album toUpdate = this.repo.findById(id).orElseThrow(AlbumNotFoundException::new);
		toUpdate.setName(toUpdate.getName());
		toUpdate.setTracks(toUpdate.getTracks());
		toUpdate.setArtist(toUpdate.getArtist());
		BeanUtils.mergeNotNull(album, toUpdate);
		Album updated = this.repo.save(toUpdate);
		return this.mapToDTO(updated);
	}

	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

//    public List<AlbumDTO> findByName(String name){
//    	return this.repo.findByName(name).stream().map(this::mapToDTO).collect(Collectors.toList());
//    }
}
