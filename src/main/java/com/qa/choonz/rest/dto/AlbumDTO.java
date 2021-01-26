package com.qa.choonz.rest.dto;

import java.util.List;

import com.qa.choonz.persistence.domain.Artist;

import lombok.Data;

@Data
public class AlbumDTO {

	private long id;
	private String name;
	private Artist artist;
	private List<TrackDTO> tracks;
}
