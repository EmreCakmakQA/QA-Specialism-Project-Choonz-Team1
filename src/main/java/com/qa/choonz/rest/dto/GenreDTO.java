package com.qa.choonz.rest.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenreDTO {

	private long id;
	private String name;
	private String description;
	private List<TrackDTO> tracks = new ArrayList<>();

}
