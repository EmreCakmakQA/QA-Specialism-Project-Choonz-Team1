INSERT INTO artist (`name`) VALUES ('Elvis Presley');
INSERT INTO album (`name`, `artist_id`) VALUES ('Vegas', 1);
INSERT INTO genre (`description`, `name`) VALUES ('Rock n Roll', '50s Rock n Roll');
INSERT INTO playlist (`name`, `description`, `user_id`) VALUES ('Rockin', 'Rock around the Clock', 1);
INSERT INTO playlist (`name`, `description`, `user_id`) VALUES ('Rock2', 'Rock again', 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Jailhouse Rock', 155, 'The warden threw a party in the county jail', 1, 1, 1);
INSERT INTO `user` (`name`, `password`) VALUES ('JohnSmith', 'passwordJS');
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 1);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 1);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (2, 1);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (2, 1);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (2, 1);

