package com.qa.choonz.rest.dto;

import java.util.List;

import com.qa.choonz.persistence.domain.Track;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaylistDTO {

	private long id;
	private String name;
	private String description;
	private List<Track> tracks;

}
