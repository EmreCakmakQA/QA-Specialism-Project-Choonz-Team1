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
//	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Track> tracks;

//	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@MapsId("id")
	@JoinTable(name = "playlist_track", joinColumns = @JoinColumn(name = "playlist_id") , inverseJoinColumns = 
			@JoinColumn(name = "track_id"))
	private List<Track> tracks;


	@JsonIgnore
	@ManyToOne
	private User user;

	public Playlist(long id, String name, String description, List<Track> tracks) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tracks = tracks;
	}

	public Playlist(String name, String description, List<Track> tracks) {
		super();
		this.name = name;
		this.description = description;
		this.tracks = tracks;
	}

	public Playlist(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Playlist [id=").append(id).append(", name=").append(name).append(", description=")
//                .append(description).append(", tracks=").append(tracks)
//                .append("]");
//        return builder.toString();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash( description, id, name, tracks);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Playlist)) {
//            return false;
//        }
//        Playlist other = (Playlist) obj;
//        return Objects.equals(description, other.description)
//                && id == other.id && Objects.equals(name, other.name) && Objects.equals(tracks, other.tracks);
//    }

}
