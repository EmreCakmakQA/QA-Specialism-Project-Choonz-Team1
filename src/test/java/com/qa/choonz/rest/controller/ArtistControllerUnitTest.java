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

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.rest.dto.ArtistDTO;
import com.qa.choonz.service.ArtistService;



@SpringBootTest
@ActiveProfiles("h2")
public class ArtistControllerUnitTest {

	@Autowired
	private ArtistController controller;

	@MockBean
	private ArtistService service;

	@Autowired
	private ModelMapper mapper;
	
	private ArtistDTO maptoDto(Artist artist) {
		return this.mapper.map(artist, ArtistDTO.class);
	}
	
	private final Artist TEST_ARTIST_1 = new Artist(1l, "Elvis Presley");
	private final Artist TEST_ARTIST_2 = new Artist(2l, "50 Cent");
	private final Artist TEST_ARTIST_3 = new Artist(3l, "Taylor Swift");

	private final List<Artist> LISTOFARTISTS = List.of(TEST_ARTIST_1,TEST_ARTIST_2,TEST_ARTIST_3);
	
	@Test
	void createTest() throws Exception {
		when(this.service.create(TEST_ARTIST_1)).thenReturn(this.maptoDto(TEST_ARTIST_1));
		assertThat(new ResponseEntity<ArtistDTO>(this.maptoDto(TEST_ARTIST_1),HttpStatus.CREATED))
		.isEqualTo(this.controller.create(TEST_ARTIST_1));
		verify(this.service, atLeastOnce()).create(TEST_ARTIST_1);
	}
	
	// Read one
	@Test
	void readOneTest() throws Exception {
		when(this.service.readOne(TEST_ARTIST_1.getId())).thenReturn(this.maptoDto(TEST_ARTIST_1));
		assertThat(new ResponseEntity<ArtistDTO>(this.maptoDto(TEST_ARTIST_1), HttpStatus.OK))
				.isEqualTo(this.controller.readOne(TEST_ARTIST_1.getId()));
		verify(this.service, atLeastOnce()).readOne(TEST_ARTIST_1.getId());
	}
	
	// Read all
	@Test
	void readAllTest() throws Exception {
		List<ArtistDTO> dtos = LISTOFARTISTS.stream().map(this::maptoDto).collect(Collectors.toList());
		when(this.service.readAll()).thenReturn(dtos);
		assertThat(this.controller.read()).isEqualTo(new ResponseEntity<>(dtos, HttpStatus.OK));
		verify(this.service, atLeastOnce()).readAll();

	}

	// Update
	@Test
	void UpdateTest() throws Exception {
		when(this.service.update(this.maptoDto(TEST_ARTIST_1), TEST_ARTIST_1.getId())).thenReturn(this.maptoDto(TEST_ARTIST_1));
		assertThat(new ResponseEntity<ArtistDTO>(this.maptoDto(TEST_ARTIST_1), HttpStatus.ACCEPTED))
				.isEqualTo(this.controller.update(this.maptoDto(TEST_ARTIST_1), TEST_ARTIST_1.getId()));
		verify(this.service, atLeastOnce()).update(this.maptoDto(TEST_ARTIST_1), TEST_ARTIST_1.getId());
	}

	// Delete
	@Test
	void deleteTest() throws Exception {
		when(this.service.delete(TEST_ARTIST_1.getId())).thenReturn(false);
		assertThat(this.controller.delete(TEST_ARTIST_1.getId()))
				.isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		verify(this.service, atLeastOnce()).delete(TEST_ARTIST_1.getId());

	}

	@Test
	void deleteTest2() throws Exception {
		when(this.service.delete(TEST_ARTIST_1.getId())).thenReturn(true);
		assertThat(this.controller.delete(TEST_ARTIST_1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		verify(this.service, atLeastOnce()).delete(TEST_ARTIST_1.getId());

	}
	
}
