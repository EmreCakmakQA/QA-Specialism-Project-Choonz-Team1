package com.qa.choonz.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.rest.dto.GenreDTO;

@SpringBootTest
@AutoConfigureMockMvc
// sql runs in order schema followed by data file - JH dont make the mistake
@Sql(scripts = { "classpath:choonz-schema.sql",
		"classpath:choonz-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "h2")
class GenreControllerIntergrationTesting {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	private GenreDTO mapToDTO(Genre genre) {
		return this.mapper.map(genre, GenreDTO.class);
	}

	private final String URI = "/genres";
	
	// Create test
	@Test
	void createTest() throws Exception {
		GenreDTO albumDTO = mapToDTO(new Genre("50s Rock n Roll", "Rock n Roll"));
		String testDTOAsJSON = this.jsonifier.writeValueAsString(albumDTO);

		RequestBuilder request = post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isCreated();
		
		
		
		GenreDTO testSavedDTO = mapToDTO(new Genre("50s Rock n Roll", "Rock n Roll"));
		testSavedDTO.setId(2L);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	// Update test
	@Test
	void updateTest() throws Exception {

		List<Track> track = new ArrayList<>();
		GenreDTO genreDTO = mapToDTO(new Genre(1, "50s Rock n Roll", "Rock n Roll", track));
		String testDTOAsJSON = this.jsonifier.writeValueAsString(genreDTO);

		RequestBuilder request = put(URI + "/update/1").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isAccepted();
				
		GenreDTO testSavedDTO = mapToDTO(new Genre(1, "50s Rock n Roll", "Rock n Roll", track));
		testSavedDTO.setId(1L);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	// Read test
	@Test
	void updateRead1() throws Exception {

		List<Track> track = new ArrayList<>();

		GenreDTO genreDTO = mapToDTO(new Genre("50s Rock n Roll", "Rock n Roll", track));
		String testDTOAsJSON = this.jsonifier.writeValueAsString(genreDTO);

		RequestBuilder request = get(URI + "/read/1").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isOk();

		GenreDTO testSavedDTO = mapToDTO(new Genre("50s Rock n Roll", "Rock n Roll", track));
		testSavedDTO.setId(1L);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
	
	// Read All test
	@Test
	void updateReadAll() throws Exception {

		List<Track> track = new ArrayList<>();
		
		GenreDTO genreDTO = mapToDTO(new Genre("50s Rock n Roll", "Rock n Roll", track));
		List<GenreDTO> listDTO = new ArrayList<>();
		listDTO.add(genreDTO);

		String testDTOAsJSON = this.jsonifier.writeValueAsString(listDTO);

		RequestBuilder request = get(URI + "/read").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isOk();

		GenreDTO testSavedDTO = mapToDTO(new Genre("50s Rock n Roll", "Rock n Roll", track));
		List<GenreDTO> listSavedDTO = new ArrayList<>();
		testSavedDTO.setId(1L);
		listSavedDTO.add(testSavedDTO);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(listSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
	
	// Delete test
	@Test
	void deleteTest() throws Exception {

		RequestBuilder request = delete(URI + "/delete/1").contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isNoContent();

		this.mvc.perform(request).andExpect(checkStatus);
	}
}
