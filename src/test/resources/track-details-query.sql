SELECT track.id
	, track.name AS track_name
	, album.name AS album
    , artist.name AS artist
    , genre.name AS genre
    , track.duration
    , track.lyrics AS lyrics
FROM track
	JOIN album ON album.id = track.album_id
    JOIN artist ON artist.id = track.artist_id
    JOIN genre ON genre.id = track.genre_id;