package com.qa.choonz.rest.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtistDTO {

    private long id;
    private String name;
    private List<AlbumDTO> albums = new ArrayList<>();
	private List<TrackDTO> tracks = new ArrayList<>();
}
