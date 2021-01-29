package com.qa.choonz.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.rest.dto.UserDTO;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:choonz-schema.sql",
		"classpath:choonz-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "h2")
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	private UserDTO mapToDTO(User user) {
		return this.mapper.map(user, UserDTO.class);
	}

	private final String URI = "/users";

	// set up some data for use during test
	// public Playlist(long id, String name, String description, User user,
	// List<Track> tracks
	// public User(long id, String name, String password, List<Playlist> playlists)
	// set up some playlist data for use during test
	// private final User TEST_USER_1 = new User(1L, "JohnSmith", "passwordJS");
	// List<Track> tracks = new ArrayList<>();
	List<Playlist> playlists = new ArrayList<>();
	List<Track> tracks = new ArrayList<>();
//	private final Playlist TEST_PLAYLIST_1 = new Playlist(1L, "Rockin", "Rock around the Clock", tracks);
//	List<Playlist> TEST_PLAYLISTS = new ArrayList<>(TEST_PLAYLIST_1);
	// private final User TEST_USER_1 = new User(1L, "JohnSmith", "passwordJS",
	// playlists);
	private final Playlist TEST_PLAYLIST_1 = new Playlist("Rockin", "Rock around the Clock");
	List<Playlist> TEST_PLAYLIST_ARRAY = new ArrayList<>();
	{
		TEST_PLAYLIST_ARRAY.add(TEST_PLAYLIST_1);
	}
	private final User TEST_USER_1 = new User(1L, "JohnSmith", "passwordJS", TEST_PLAYLIST_ARRAY);

	// Create test
	@Test
	void createTest() throws Exception {
		UserDTO userDTO = mapToDTO(new User("DaveyJones", "passwordDJ"));
		String testDTOAsJSON = this.jsonifier.writeValueAsString(userDTO);

		RequestBuilder request = post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		UserDTO testSavedDTO = mapToDTO(new User("DaveyJones", "passwordDJ"));
		testSavedDTO.setId(2L);
		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);

		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	// Update test
//	@Test
//	void updateTest() throws Exception {
//
//		UserDTO userDTO = mapToDTO(TEST_USER_1);
//		String testDTOAsJSON = this.jsonifier.writeValueAsString(userDTO);
//
//		RequestBuilder request = put(URI + "/update/1").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);
//
//		ResultMatcher checkStatus = status().isAccepted();
//
//		UserDTO testSavedDTO = mapToDTO(TEST_USER_1);
//		testSavedDTO.setId(1L);
//		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);
//
//		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//	}

	// Read test

//	@Test
//	void updateRead1() throws Exception {
//
//		UserDTO userDTO = mapToDTO(1, "JohnSmith", "passwordJS", TEST_PLAYLIST_ARRAY);
//		String testDTOAsJSON = this.jsonifier.writeValueAsString(userDTO);
//
//		RequestBuilder request = get(URI + "/read/1").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);
//
//		ResultMatcher checkStatus = status().isOk();
//
//		UserDTO testSavedDTO = mapToDTO(1, "JohnSmith", "passwordJS", playlists);
//		testSavedDTO.setId(1L);
//		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);
//
//		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//
//	}

	// Read All test
//	@Test
//	void updateReadAll() throws Exception {
//
//		UserDTO userDTO = mapToDTO(new User(1, "JohnSmith", "passwordJS", playlists));
//		List<UserDTO> listDTO = new ArrayList<>();
//		listDTO.add(userDTO);
//
//		String testDTOAsJSON = this.jsonifier.writeValueAsString(listDTO);
//
//		RequestBuilder request = get(URI + "/read").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);
//
//		ResultMatcher checkStatus = status().isOk();
//
//		UserDTO testSavedDTO = mapToDTO(new User(1, "JohnSmith", "passwordJS", playlists));
//		List<UserDTO> listSavedDTO = new ArrayList<>();
//		testSavedDTO.setId(1L);
//		listSavedDTO.add(testSavedDTO);
//		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(listSavedDTO);
//
//		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//
//	}

	// Delete test
	@Test
	void deleteTest() throws Exception {

		RequestBuilder request = delete(URI + "/delete/1").contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isNoContent();

		this.mvc.perform(request).andExpect(checkStatus);
	}
}
