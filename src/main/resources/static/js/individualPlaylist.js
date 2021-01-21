// Dummy Data
let reggae = "./img/reggae.png"
let rock = "./img/rock.png"
let pop = "./img/pop.png"

let testPlaylist1 = {
    "id": 1,
    "name": "Reggae",
    "description": "A collection of Reggae music",
    "artwork": reggae,
    "tracks": [{
        "id": 1,
        "name": "One Love",
        "artist": "Bob Marley",
        "album": "Exodus",
        "duration": 5,
        "lyrics": "One love, one heart, lets get together and feel alright...",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 2,
        "name": "Concrete Jungle",
        "artist": "Bob Marley",
        "album": "Exodus",
        "duration": 5,
        "lyrics": "No sun will shine in my day today,",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 3,
        "name": "Satisfy My Soul",
        "artist": "Bob Marley",
        "album": "Exodus",
        "duration": 5,
        "lyrics": "One love, one heart, lets get together and feel alright...",
        "trackURL": "./html/tracks.html"
    }]
}

let testPlaylist2 = {
    "id": 2,
    "name": "Rock",
    "description": "Rock 'n Roll for the Soul",
    "artwork": rock,
    "tracks": [{
        "id": 1,
        "name": "Highway To Hell",
        "album": "ACDC Greatest Hits",
        "artist": "ACDC",
        "duration": 5,
        "lyrics": "I'm on the highway to hell!",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 2,
        "name": "Stairway To Heaven",
        "album": "Greatest Hits: LZ",
        "artist": "Led Zeppelin",
        "duration": 5,
        "lyrics": "and shes buying the stairway to heaven",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 3,
        "name": "Back In Black",
        "album": "ACDC Greatest Hits",
        "artist": "ACDC",
        "duration": 5,
        "lyrics": "Cos I'm back in black, yes I'm back in black!",
        "trackURL": "./html/tracks.html"
    }]
}

let testPlaylist3 = {
    "id": 3,
    "name": "Pop",
    "description": "Pop till you drop!",
    "artwork": pop,
    "tracks": [{
        "id": 1,
        "name": "Africa",
        "artist": "Toto",
        "album": "Toto's Greatest Hits",
        "duration": 5,
        "lyrics": "I bless the rains down in Africa",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 2,
        "name": "I Feel It Coming",
        "artist": "The Weekend",
        "album": "The Weekend's Album",
        "duration": 5,
        "lyrics": "Tell me what you really like, we don't even have to fight, just take it step by step",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 3,
        "name": "Smooth Criminal",
        "artist": "Michael Jackson",
        "album": "The Black Album",
        "duration": 5,
        "lyrics": "You've been hit by, you've been struck by a smooth criminal",
        "trackURL": "./html/tracks.html"
    }
    ]
}


// Playlist Array

let playlistsArray = [testPlaylist1, testPlaylist2, testPlaylist3];

// Add tracks to page 

let tracksDiv = document.querySelector("div#tracks");
createTrackCard();

function createTrackCard() {



    for (let i = 0; i < playlistsArray.length; i++) {
        for (tracks of playlistsArray[i].tracks) {

            let name = document.createElement("a");
            let artist = document.createElement("a");
            let album = document.createElement("a");
            let genre = document.createElement("a");

            name.innerText = tracks.name;
            artist.innerText = tracks.artist;
            album.innerText = tracks.album;

            name.href = "./html/individualTrack.html"
            artist.href = "./html/individualArtist.html"
            album.href = "./html/individualAlbum.html"

            let card = document.createElement("div");
            card.setAttribute("id", "card")

            card.appendChild(name)
            card.appendChild(artist)
            card.appendChild(album)

            tracksDiv.append(card);
        }




        // genre.href = "./html/individualGenre.html"


        // let addToPlaylistBtn = document.createElement("button");
        // addToPlaylistBtn.setAttribute("class", "btn")
        // addToPlaylistBtn.setAttribute("id", "addToPlaylistBtn")
        // addToPlaylistBtn.innerText = "💚"

        // addToPlaylistBtn.addEventListener("mouseenter", (event) => {
        //     event.target.innerText = "💗"
        // })

        // addToPlaylistBtn.addEventListener("mouseleave", (event) => {
        //     event.target.innerText = "💚"
        // })


        // card.appendChild(genre)
        // card.appendChild(addToPlaylistBtn);


        // tracksDiv.append(card);



    }
}



