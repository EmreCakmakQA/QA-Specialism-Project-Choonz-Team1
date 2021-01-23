package com.qa.choonz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.choonz.exception.GenreNotFoundException;
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.persistence.repository.GenreRepository;
import com.qa.choonz.rest.dto.GenreDTO;
import com.qa.choonz.utils.BeanUtils;

@Service
public class GenreService {

    private GenreRepository repo;
    private ModelMapper mapper;

    private GenreDTO mapToDTO(Genre genre) {
        return this.mapper.map(genre, GenreDTO.class);
    }
    
    @Autowired
    public GenreService(GenreRepository repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }



    public GenreDTO create(Genre genre) {
        Genre created = this.repo.save(genre);
        return this.mapToDTO(created);
    }

    public List<GenreDTO> readAll() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public GenreDTO readOne(long id) {
        Genre found = this.repo.findById(id).orElseThrow(GenreNotFoundException::new);
        return this.mapToDTO(found);
    }

    public GenreDTO update(GenreDTO genreDTO, long id) {
        Genre toUpdate = this.repo.findById(id).orElseThrow(GenreNotFoundException::new);
        toUpdate.setName(genreDTO.getName());
        toUpdate.setDescription(genreDTO.getDescription());
        BeanUtils.mergeNotNull(genreDTO, toUpdate);
        Genre updated = this.repo.save(toUpdate);
        return this.mapToDTO(updated);
    }

    public boolean delete(long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

}
