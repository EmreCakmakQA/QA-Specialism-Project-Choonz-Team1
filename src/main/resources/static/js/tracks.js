// Add tracks to page 

let tracksDiv = document.querySelector("div#tracks");
createTrackCard();

function createTrackCard() {


    for (let i = 1; i <= 51; i++) {

        let card = document.createElement("div");
        card.setAttribute("id", "card")

        let track = {
            "id": [i],
            "artist": "Bob Marley",
            "album": "The Waling Wailers",
            "track_name": "One Love",
            "lyrics": "some lyrics",
            "genre": "Reggae"
        }



        let name = document.createElement("a");
        let artist = document.createElement("a");
        let album = document.createElement("a");
        let genre = document.createElement("a");


        name.innerText = track.track_name;
        artist.innerText = track.artist;
        album.innerText = track.album;
        genre.innerText = track.genre;


        name.href = "./html/individualTrack.html"
        artist.href = "./html/individualArtist.html"
        album.href = "./html/individualAlbum.html"
        genre.href = "./html/individualGenre.html"


        let addToPlaylistBtn = document.createElement("button");
        addToPlaylistBtn.setAttribute("class", "btn")
        addToPlaylistBtn.setAttribute("id", "addToPlaylistBtn")
        addToPlaylistBtn.innerText = "💚"

        addToPlaylistBtn.addEventListener("mouseenter", (event) => {
            event.target.innerText = "💗"
        })

        addToPlaylistBtn.addEventListener("mouseleave", (event) => {
            event.target.innerText = "💚"
        })

        card.appendChild(name)
        card.appendChild(artist)
        card.appendChild(album)
        card.appendChild(genre)
        card.appendChild(addToPlaylistBtn);


        tracksDiv.append(card);



    }
}



