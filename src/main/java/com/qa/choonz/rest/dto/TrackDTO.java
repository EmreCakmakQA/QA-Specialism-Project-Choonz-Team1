package com.qa.choonz.rest.dto;

import java.util.Objects;

import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Playlist;

public class TrackDTO {

    private long id;
    private String name;
    private Album album;
    private Playlist playlist;
    private int duration;
    private String lyrics;

    public TrackDTO() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public TrackDTO( long id, String name, Album album, Playlist playlist, int duration, String lyrics) {
        super();
        this.id = id;
        this.name = name;
        this.album = album;
        this.playlist = playlist;
        this.duration = duration;
        this.lyrics = lyrics;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Album getAlbum() {
    	return album;
    }
    
    public void setAlbum(Album album) {
    	this.album = album;
    }
    
    public Playlist getPlaylist() {
    	return playlist;
    }
    
    public void setPlaylist(Playlist playlist) {
    	this.playlist = playlist;
    }
    
    public int getDuration() {
    	return duration;
    }
    
    public void setDuration(int duration) {
    	this.duration = duration;
    }
    
    public String getLyrics() {
    	return lyrics;
    }
    
    public void setLyrics(String lyrics) {
    	this.lyrics = lyrics;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TrackDTO [id=").append(id).append(", name=").append(name).append(", albums=").append(album)
                .append(", playlist=").append(playlist).append(", duration=").append(duration).append(", lyrics=").append(lyrics)
                .append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, playlist, duration, id, name, lyrics);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackDTO)) {
            return false;
        }
        TrackDTO other = (TrackDTO) obj;
        return Objects.equals(album, other.album) && Objects.equals(playlist, other.playlist)
                && Objects.equals(duration, other.duration) && id == other.id && Objects.equals(name, other.name)
                && Objects.equals(lyrics, other.lyrics);
    }
}