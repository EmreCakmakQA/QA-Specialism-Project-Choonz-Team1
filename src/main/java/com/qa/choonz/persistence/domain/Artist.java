package com.qa.choonz.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Album> albums;

	@JsonIgnore
	@OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Track> tracks;

	public Artist(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Artist(String name) {
		super();
		this.name = name;
	}

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Artist [id=").append(id).append(", name=").append(name).append(", albums=").append(albums)
//                .append("]");
//        return builder.toString();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(albums, id, name);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Artist)) {
//            return false;
//        }
//        Artist other = (Artist) obj;
//        return Objects.equals(albums, other.albums) && id == other.id && Objects.equals(name, other.name);
//    }

}
