package com.qa.choonz.rest.dto;

import java.util.List;

import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.persistence.domain.Playlist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrackDTO {

	private long id;
	private String name;
	private Album album;
	private List<Playlist> playlists;
	private Genre genre;
	private Artist artist;
	private int duration;
	private String lyrics;
}
