select track.id
	, track.name as track_name
	, album.name as album
    , artist.name as artist
    , genre.name as genre
    , track.duration
    , track.lyrics as lyrics
from track
	join album on album.id = track.album_id
    join artist on artist.id = track.artist_id
    join genre on genre.id = track.genre_id;