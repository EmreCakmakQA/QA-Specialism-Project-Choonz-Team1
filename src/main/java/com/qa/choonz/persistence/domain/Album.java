package com.qa.choonz.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Track> tracks;

    @JsonIgnore
    @ManyToOne
    private Artist artist;

    
    public Album(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Album(long id, String name, List<Track> tracks) {
        super();
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }
    
    public Album(long id, String name, List<Track> tracks, Artist artist) {
        super();
        this.id = id;
        this.name = name;
        this.tracks = tracks;
        this.artist  = artist;
    }
    
    public Album(String name, List<Track> tracks, Artist artist) {
        super();
        this.name = name;
        this.tracks = tracks;
        this.artist  = artist;
    }
    
    public Album(String name, Artist artist) {
        super();
        this.name = name;
        this.artist = artist;
    }
    
    public Album(String name, List<Track> tracks) {
        super();
        this.name = name;
        this.tracks = tracks;
    }
    
    public Album(String name) {
        super();
        this.name = name;
    }
    
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Album [id=").append(id).append(", name=").append(name).append(", tracks=").append(tracks)
//                .append(", artist=").append(artist).append("]");
//        return builder.toString();
//    }
//    //.append(", genre=").append(genre)
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(artist, id, name, tracks);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Album)) {
//            return false;
//        }
//        Album other = (Album) obj;
//        return Objects.equals(artist, other.artist) && id == other.id && Objects.equals(name, other.name)
//                && Objects.equals(tracks, other.tracks);
//    }
//
//    //&& Objects.equals(genre, other.genre)
}
