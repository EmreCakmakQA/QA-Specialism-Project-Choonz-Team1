package com.qa.choonz.rest.dto;

import java.util.Set;

import com.qa.choonz.persistence.domain.Track;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaylistDTO {

	private long id;
	private String name;
	private String description;
	private Set<Track> tracks;

}
