package com.qa.choonz.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.rest.dto.GenreDTO;
import com.qa.choonz.service.GenreService;

@SpringBootTest
@ActiveProfiles("h2")
public class GenreControllerUnitTest {

	@Autowired
	private GenreController controller;

	@MockBean
	private GenreService service;

	@Autowired
	private ModelMapper mapper;

	private GenreDTO mapToDTO(Genre album) {
		return this.mapper.map(album, GenreDTO.class);
	}

	// set up some data for use during test
	private final Genre TEST_GENRE_1 = new Genre(1L, "Rock n roll", "Rock", null);
	private final Genre TEST_GENRE_2 = new Genre(2L, "Rhythm and lyrics", "Rap", null);
	private final Genre TEST_GENRE_3 = new Genre(3L, "Pop music", "pop", null);

	private final List<Genre> GENRE_LIST = List.of(TEST_GENRE_1, TEST_GENRE_2, TEST_GENRE_3);

	// create
	@Test // Test 1
	void createTest() throws Exception {
		when(this.service.create(TEST_GENRE_1)).thenReturn(this.mapToDTO(TEST_GENRE_1));
		assertThat(new ResponseEntity<GenreDTO>(this.mapToDTO(TEST_GENRE_1), HttpStatus.CREATED))
				.isEqualTo(this.controller.create(TEST_GENRE_1));
		verify(this.service, atLeastOnce()).create(TEST_GENRE_1);
	}

	// Read one
	@Test // Test 2
	void readOneTest() throws Exception {
		when(this.service.readOne(TEST_GENRE_1.getId())).thenReturn(this.mapToDTO(TEST_GENRE_1));
		assertThat(new ResponseEntity<GenreDTO>(this.mapToDTO(TEST_GENRE_1), HttpStatus.OK))
				.isEqualTo(this.controller.readOne(TEST_GENRE_1.getId()));
		verify(this.service, atLeastOnce()).readOne(TEST_GENRE_1.getId());
	}

	// Read all
	@Test // Test 3
	void readAllTest() throws Exception {
		List<GenreDTO> dtoList = GENRE_LIST.stream().map(this::mapToDTO).collect(Collectors.toList());
		when(this.service.readAll()).thenReturn(dtoList);
		assertThat(this.controller.readAll()).isEqualTo(new ResponseEntity<>(dtoList, HttpStatus.OK));
		verify(this.service, atLeastOnce()).readAll();
	}

	// Update
	@Test // Test 4
	void updateTest() throws Exception {

		// rules WHEN... THEN DO....
		when(this.service.update(this.mapToDTO(TEST_GENRE_1), TEST_GENRE_1.getId()))
				.thenReturn(this.mapToDTO(TEST_GENRE_1));

		// processes Store variables / perform requests....
		// assertions
		assertThat(new ResponseEntity<GenreDTO>(this.mapToDTO(TEST_GENRE_1), HttpStatus.ACCEPTED))
				.isEqualTo(this.controller.update(this.mapToDTO(TEST_GENRE_1), TEST_GENRE_1.getId()));

		// verification Check how many times rule has been applied
		verify(this.service, atLeastOnce()).update(this.mapToDTO(TEST_GENRE_1), TEST_GENRE_1.getId());
	}

	// Delete
	@Test // Test 5
	void deleteTest() throws Exception {
		when(this.service.delete(TEST_GENRE_1.getId())).thenReturn(false);
		assertThat(this.controller.delete(TEST_GENRE_1.getId()))
				.isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		verify(this.service, atLeastOnce()).delete(TEST_GENRE_1.getId());
	}

	// Delete
	@Test // Test 6
	void deleteTest2() throws Exception {
		when(this.service.delete(TEST_GENRE_1.getId())).thenReturn(true);
		assertThat(this.controller.delete(TEST_GENRE_1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		verify(this.service, atLeastOnce()).delete(TEST_GENRE_1.getId());
	}
}
