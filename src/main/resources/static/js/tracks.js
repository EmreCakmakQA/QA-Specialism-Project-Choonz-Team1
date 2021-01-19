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



        let name = document.createElement("p");
        let artist = document.createElement("p");
        let album = document.createElement("p");
        let genre = document.createElement("p");


        name.innerText = track.track_name;
        artist.innerText = track.artist;
        album.innerText = track.album;
        genre.innerText = track.genre;


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



