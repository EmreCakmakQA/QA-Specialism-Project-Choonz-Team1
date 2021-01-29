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

import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.rest.dto.UserDTO;
import com.qa.choonz.service.UserService;

@SpringBootTest
@ActiveProfiles("h2")
public class UserControllerUnitTest {

	@Autowired
	private UserController controller;

	@MockBean
	private UserService service;

	@Autowired
	private ModelMapper mapper;

	private UserDTO maptoDto(User user) {
		return this.mapper.map(user, UserDTO.class);
	}

	private final User TEST_USER_1 = new User(1l, "JohnSmith", "passwordJS");
	private final User TEST_USER_2 = new User(2l, "JaneBrown", "passwordJB");

	private final List<User> LISTOFUSERS = List.of(TEST_USER_1, TEST_USER_2);

	@Test
	void createTest() throws Exception {
		when(this.service.create(TEST_USER_1)).thenReturn(this.maptoDto(TEST_USER_1));
		assertThat(new ResponseEntity<UserDTO>(this.maptoDto(TEST_USER_1), HttpStatus.CREATED))
				.isEqualTo(this.controller.create(TEST_USER_1));
		verify(this.service, atLeastOnce()).create(TEST_USER_1);
	}

	// Read one
	@Test
	void readOneTest() throws Exception {
		when(this.service.readOne(TEST_USER_1.getId())).thenReturn(this.maptoDto(TEST_USER_1));
		assertThat(new ResponseEntity<UserDTO>(this.maptoDto(TEST_USER_1), HttpStatus.OK))
				.isEqualTo(this.controller.readOne(TEST_USER_1.getId()));
		verify(this.service, atLeastOnce()).readOne(TEST_USER_1.getId());
	}

	// Read all
	@Test
	void readAllTest() throws Exception {
		List<UserDTO> userDTOList = LISTOFUSERS.stream().map(this::maptoDto).collect(Collectors.toList());
		when(this.service.readAll()).thenReturn(userDTOList);
		assertThat(this.controller.read()).isEqualTo(new ResponseEntity<>(userDTOList, HttpStatus.OK));
		verify(this.service, atLeastOnce()).readAll();

	}

	// Update
	@Test
	void UpdateTest() throws Exception {
		when(this.service.update(this.maptoDto(TEST_USER_1), TEST_USER_1.getId()))
				.thenReturn(this.maptoDto(TEST_USER_1));
		assertThat(new ResponseEntity<UserDTO>(this.maptoDto(TEST_USER_1), HttpStatus.ACCEPTED))
				.isEqualTo(this.controller.update(this.maptoDto(TEST_USER_1), TEST_USER_1.getId()));
		verify(this.service, atLeastOnce()).update(this.maptoDto(TEST_USER_1), TEST_USER_1.getId());
	}

	// Delete
	@Test
	void deleteTest1() throws Exception {
		when(this.service.delete(TEST_USER_1.getId())).thenReturn(false);
		assertThat(this.controller.delete(TEST_USER_1.getId()))
				.isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
		verify(this.service, atLeastOnce()).delete(TEST_USER_1.getId());

	}

	@Test
	void deleteTest2() throws Exception {
		when(this.service.delete(TEST_USER_1.getId())).thenReturn(true);
		assertThat(this.controller.delete(TEST_USER_1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		verify(this.service, atLeastOnce()).delete(TEST_USER_1.getId());

	}
}