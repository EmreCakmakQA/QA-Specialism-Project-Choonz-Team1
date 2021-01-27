package com.qa.choonz.rest.dto;

import java.util.Set;

import com.qa.choonz.persistence.domain.Album;
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
	private Set<Playlist> playlists;
	private Genre genre;
	private int duration;
	private String lyrics;
}
