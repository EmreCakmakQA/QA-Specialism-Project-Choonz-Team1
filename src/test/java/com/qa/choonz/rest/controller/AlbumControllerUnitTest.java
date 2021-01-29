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

import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.rest.dto.AlbumDTO;
import com.qa.choonz.service.AlbumService;

@SpringBootTest
@ActiveProfiles("h2")
public class AlbumControllerUnitTest {

	@Autowired
	private AlbumController controller;

	@MockBean
	private AlbumService service;

	@Autowired
	private ModelMapper mapper;

	private AlbumDTO mapToDTO(Album album) {
		return this.mapper.map(album, AlbumDTO.class);
	}

	// set up some data for use during test
	private final Album TEST_ALBUM_1 = new Album(1L, "Vegas");
	private final Album TEST_ALBUM_2 = new Album(2L, "Northern Lights");
	private final Album TEST_ALBUM_3 = new Album(3L, "21");

	private final List<Album> ALBUM_LIST = List.of(TEST_ALBUM_1, TEST_ALBUM_2, TEST_ALBUM_3);

	// create
	@Test // Test 1
	void createTest() throws Exception {
		when(this.service.create(TEST_ALBUM_1)).thenReturn(this.mapToDTO(TEST_ALBUM_1));
		assertThat(new ResponseEntity<AlbumDTO>(this.mapToDTO(TEST_ALBUM_1), HttpStatus.CREATED))
				.isEqualTo(this.controller.create(TEST_ALBUM_1));
		verify(this.service, atLeastOnce()).create(TEST_ALBUM_1);
	}

	// Read one
	@Test // Test 2
	void readOneTest() throws Exception {
		when(this.service.readOne(TEST_ALBUM_1.getId())).thenReturn(this.mapToDTO(TEST_ALBUM_1));
		assertThat(new ResponseEntity<AlbumDTO>(this.mapToDTO(TEST_ALBUM_1), HttpStatus.OK))
				.isEqualTo(this.controller.readOne(TEST_ALBUM_1.getId()));
		verify(this.service, atLeastOnce()).readOne(TEST_ALBUM_1.getId());
	}

	// Read all
	@Test // Test 3
	void readAllTest() throws Exception {
		List<AlbumDTO> dtoList = ALBUM_LIST.stream().map(this::mapToDTO).collect(Collectors.toList());
		when(this.service.readAll()).thenReturn(dtoList);
		assertThat(this.controller.readAll()).isEqualTo(new ResponseEntity<>(dtoList, HttpStatus.OK));
		verify(this.service, atLeastOnce()).readAll();
	}

	// Update
	@Test // Test 4
	void updateTest() throws Exception {

		// rules WHEN... THEN DO....
		when(this.service.update(this.mapToDTO(TEST_ALBUM_1), TEST_ALBUM_1.getId()))
				.thenReturn(this.mapToDTO(TEST_ALBUM_1));

		// processes Store variables / perform requests....
		// assertions
		assertThat(new ResponseEntity<AlbumDTO>(this.mapToDTO(TEST_ALBUM_1), HttpStatus.ACCEPTED))
				.isEqualTo(this.controller.update(this.mapToDTO(TEST_ALBUM_1), TEST_ALBUM_1.getId()));

		// verification Check how many times rule has been applied
		verify(this.service, atLeastOnce()).update(this.mapToDTO(TEST_ALBUM_1), TEST_ALBUM_1.getId());
	}

	// Delete
	@Test // Test 5
	void deleteTest() throws Exception {
		when(this.service.delete(TEST_ALBUM_1.getId())).thenReturn(false);
		assertThat(this.controller.delete(TEST_ALBUM_1.getId()))
				.isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		verify(this.service, atLeastOnce()).delete(TEST_ALBUM_1.getId());
	}

	// Delete
	@Test // Test 6
	void deleteTest2() throws Exception {
		when(this.service.delete(TEST_ALBUM_1.getId())).thenReturn(true);
		assertThat(this.controller.delete(TEST_ALBUM_1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		verify(this.service, atLeastOnce()).delete(TEST_ALBUM_1.getId());
	}

}
