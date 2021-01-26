package com.qa.choonz.rest.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private long id;
	private String name;
	private String password;
	private List<PlaylistDTO> playlists = new ArrayList<>();

}
