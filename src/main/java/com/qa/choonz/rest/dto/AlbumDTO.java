package com.qa.choonz.rest.dto;

import java.util.List;

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Track;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AlbumDTO {

    private long id;
    private String name;
    private List<Track> tracks;
    private Artist artist;
    
}
