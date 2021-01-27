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

//	@JsonIgnore
//	@ManyToOne
//	private Playlist playlist;

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

	public Track(long id, String name, Album album, List<Playlist> playlists, int duration, Genre genre, String lyrics) {
		super();
		this.id = id;
		this.name = name;
		this.album = album;
		this.playlists = playlists;
		this.duration = duration;
		this.genre = genre;
		this.lyrics = lyrics;
	}

	public Track(String name, Album album, List<Playlist> playlists, int duration, Genre genre, String lyrics) {
		super();
		this.name = name;
		this.album = album;
		this.playlists = playlists;
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

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Track [id=").append(id).append(", name=").append(name).append(", album=").append(album)
//                .append(", playlist=").append(playlist).append(", duration=").append(duration).append(", lyrics=")
//                .append(lyrics).append("]");
//        return builder.toString();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(album, duration, id, lyrics, name, playlist);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Track)) {
//            return false;
//        }
//        Track other = (Track) obj;
//        return Objects.equals(album, other.album) && duration == other.duration && id == other.id
//                && Objects.equals(lyrics, other.lyrics) && Objects.equals(name, other.name)
//                && Objects.equals(playlist, other.playlist);
//    }

}
