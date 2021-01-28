package com.qa.choonz.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "playlist")
@Data
@NoArgsConstructor
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String name;

	@NotNull
	@Size(max = 500)
	@Column(unique = true)
	private String description;

//	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@MapsId("id")
	@JoinTable(name = "playlist_track", joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "track_id"))
	private List<Track> tracks;

	@JsonIgnore
	@ManyToOne
	private User user;

	public Playlist(long id, String name, String description, User user, List<Track> tracks) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.user = user;
		this.tracks = tracks;
	}

	public Playlist(String name, String description, User user, List<Track> tracks) {
		super();
		this.name = name;
		this.description = description;
		this.user = user;
		this.tracks = tracks;
	}

	public Playlist(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

}
