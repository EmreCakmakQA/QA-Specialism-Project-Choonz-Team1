INSERT INTO artist (`name`) VALUES ('Elvis Presley');
INSERT INTO artist (`name`) VALUES ('AC/DC');
INSERT INTO artist (`name`) VALUES ('The Fishermans Friends');
INSERT INTO artist (`name`) VALUES ('Various');
INSERT INTO album (`name`, `artist_id`) VALUES ('Golden', 1);
INSERT INTO album (`name`, `artist_id`) VALUES ('Rock or Bust', 2);
INSERT INTO album (`name`, `artist_id`) VALUES ('Best of...', 4);
INSERT INTO genre (`name`, `description`) VALUES ('Rock n Roll', 'Rock n Roll music including Hard Rock, Blues Rock and Heavy Metal');
INSERT INTO genre (`name`, `description`) VALUES ('Pop', 'Popular music from all decades');
INSERT INTO genre (`name`, `description`) VALUES ('Country', 'Country and Folk music');
INSERT INTO playlist (`name`, `description`, `user_id`) VALUES ('Rockin', 'Rock around the Clock', 1);
INSERT INTO playlist (`name`, `description`, `user_id`) VALUES ('Rock2', 'Rock again', 1);
INSERT INTO playlist (`name`, `description`, `user_id`) VALUES ('Shanties', 'Traditional Sea Shanties', 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Jailhouse Rock', 156, 'The warden threw a party in the county jail', 1, 1, 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Hound Dog', 138, 'You aint nothin but a hound dog, Cryin all the time', 1, 1, 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Tutti Frutti', 119, 'A-bop-bop-a-loom-op a-lop-bop-boom, Tutti frutti au rutti', 1, 1, 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Rock or Bust', 202, 'Hey yeah, Are you ready, We be a guitar band, We play across the land', 2, 2, 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Dogs of War', 215, 'Dogs of War, Dogs of War, (Soldier of fortune), Dogs of war', 2, 2, 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Rock the Blues Away', 204, 'Drivin in my car, Headed for the local bar', 2, 2, 1);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Santiana', 199, 'Oh! Santiana gained a day, Away Santiana!, "Napoleon of the West", they say, Along the plains of Mexico', 3, 3, 3);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Billy OShea', 215, 'We all got drunk in Dublin city, Fall down me Billy, We all got drunk, sure mores the pity, Fall down Billy OShea', 3, 3, 3);
INSERT INTO track (`name`, `duration`, `lyrics`, `album_id`, `artist_id`,`genre_id`) VALUES ('Big Jim', 215, 'A famous scottish angling club arranged to hold a match, and five pounds offered as the prize
to him with the biggest catch', 3, 4, 3);
INSERT INTO `user` (`name`, `password`) VALUES ('FeaturedUser', 'genpass');
INSERT INTO `user` (`name`, `password`) VALUES ('JohnSmith', 'passwordJS');
INSERT INTO `user` (`name`, `password`) VALUES ('JaneBrown', 'passwordJB');
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 1);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 2);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (2, 1);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (2, 2);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 3);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 4);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 5);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (1, 6);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (3, 7);
INSERT INTO playlist_track (`playlist_id`, `track_id`) VALUES (3, 8);

