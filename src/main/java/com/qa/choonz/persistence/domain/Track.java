package com.qa.choonz.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "track")
@Data
@NoArgsConstructor
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String name;

	@JsonIgnore
	@ManyToOne
	private Album album;

	@JsonIgnore
	@ManyToMany(mappedBy = "tracks")
	private List<Playlist> playlists;

	@JsonIgnore
	@ManyToOne
	private Artist artist;

	// in seconds
	private int duration;

	@JsonIgnore
	@ManyToOne
	private Genre genre;

	private String lyrics;

	public Track(long id, String name, Album album, List<Playlist> playlists, Artist artist, int duration, Genre genre,
			String lyrics) {
		super();
		this.id = id;
		this.name = name;
		this.album = album;
		this.playlists = playlists;
		this.artist = artist;
		this.duration = duration;
		this.genre = genre;
		this.lyrics = lyrics;
	}

	public Track(String name, Album album, List<Playlist> playlists, Artist artist, int duration, Genre genre,
			String lyrics) {
		super();
		this.name = name;
		this.album = album;
		this.playlists = playlists;
		this.artist = artist;
		this.duration = duration;
		this.genre = genre;
		this.lyrics = lyrics;
	}

	public Track(long id, String name, int duration, String lyrics) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.lyrics = lyrics;
	}

	public Track(String name, int duration, String lyrics) {
		this.name = name;
		this.duration = duration;
		this.lyrics = lyrics;
	}

	public Track(String name, int duration, String lyrics, List<Playlist> playlists) {
		super();
		this.name = name;
		this.duration = duration;
		this.lyrics = lyrics;
		this.playlists = playlists;
	}

}
