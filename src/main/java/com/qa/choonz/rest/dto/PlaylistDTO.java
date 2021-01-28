package com.qa.choonz.rest.dto;

import java.util.List;

import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaylistDTO {

	private long id;
	private String name;
	private String description;
	private User user;
	private List<Track> tracks;

}
