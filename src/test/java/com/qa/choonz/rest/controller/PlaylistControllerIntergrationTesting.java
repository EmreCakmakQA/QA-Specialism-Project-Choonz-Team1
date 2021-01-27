package com.qa.choonz.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.rest.dto.PlaylistDTO;

@SpringBootTest
@AutoConfigureMockMvc
// sql runs in order schema followed by data file - JH dont make the mistake
@Sql(scripts = { "classpath:choonz-schema.sql",
		"classpath:choonz-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "h2")
class PlaylistControllerIntergrationTesting {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	private PlaylistDTO mapToDTO(Playlist playlist) {
		return this.mapper.map(playlist, PlaylistDTO.class);
	}

	private final String URI = "/playlists";

	// Create test
	@Test
	void createTest() throws Exception {
		PlaylistDTO playlistDTO = mapToDTO(new Playlist("Pop", "90's Pop"));
		String testDTOAsJSON = this.jsonifier.writeValueAsString(playlistDTO);

		RequestBuilder request = post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		PlaylistDTO testSavedDTO = mapToDTO(new Playlist("Pop", "90's Pop"));
		testSavedDTO.setId(2L);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	// Update test
	@Test
	void updateTest() throws Exception {

		Set<Track> tracks = new HashSet<>();
		PlaylistDTO playlistDTO = mapToDTO(new Playlist(1, "HipHop", "90's HipHop", tracks));
		String testDTOAsJSON = this.jsonifier.writeValueAsString(playlistDTO);

		RequestBuilder request = put(URI + "/update/1").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		PlaylistDTO testSavedDTO = mapToDTO(new Playlist(1, "HipHop", "90's HipHop", tracks));
		testSavedDTO.setId(1L);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	// Read test
	@Test
	void updateRead1() throws Exception {

		Set<Track> tracks = new HashSet<>();

		PlaylistDTO playlistDTO = mapToDTO(new Playlist("Rockin", "Rock around the Clock", tracks));
		String testDTOAsJSON = this.jsonifier.writeValueAsString(playlistDTO);

		RequestBuilder request = get(URI + "/read/1").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isOk();

		PlaylistDTO testSavedDTO = mapToDTO(new Playlist("Rockin", "Rock around the Clock", tracks));
		testSavedDTO.setId(1L);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	// Read All test
	@Test
	void updateReadAll() throws Exception {
		Set<Track> tracks = new HashSet<>();
		PlaylistDTO playlistDTO = mapToDTO(new Playlist("Rockin", "Rock around the Clock", tracks));
		List<PlaylistDTO> listDTO = new ArrayList<>();
		listDTO.add(playlistDTO);

		String testDTOAsJSON = this.jsonifier.writeValueAsString(listDTO);

		RequestBuilder request = get(URI + "/read").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isOk();

		PlaylistDTO testSavedDTO = mapToDTO(new Playlist("Rockin", "Rock around the Clock", tracks));
		List<PlaylistDTO> listSavedDTO = new ArrayList<>();
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
