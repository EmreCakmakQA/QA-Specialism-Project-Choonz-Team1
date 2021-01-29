-- playlist (id BIGINT PKEY, name VARCHAR(100) NOT NULL, description VARCHAR(500), user_id bigint);
-- track (id BIGINT PKEY, name VARCHAR(100) NOT NULL, album_id bigint, artist_id bigint, duration INT NOT NULL, genre_id bigint, lyrics VARCHAR(255));
-- user (id BIGINT PKEY, name VARCHAR(50) NOT NULL, password VARCHAR(60));
-- playlist_track (id BIGINT PKEY, playlist_id bigint, track_id bigint);
SELECT user.name AS user
	, playlist.name AS playlist_name
    , playlist.description AS playlist_description
    , track.name AS track
FROM playlist
JOIN user ON user.id = playlist.user_id
JOIN playlist_track ON playlist_track.playlist_id = playlist.id
JOIN track ON track.id = playlist_track.track_id
ORDER BY user_id,
	playlist_id;