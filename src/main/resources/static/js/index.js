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
        "album": "Exodus",
        "duration": 5,
        "lyrics": "One love, one heart, lets get together and feel alright...",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 2,
        "name": "Concrete Jungle",
        "album": "Exodus",
        "duration": 5,
        "lyrics": "No sun will shine in my day today,",
        "trackURL": "./html/tracks.html"
    },
    {
        "id": 3,
        "name": "One Love",
        "album": "Exodus",
        "duration": 5,
        "lyrics": "One love, one heart, lets get together and feel alright...",
        "trackURL": "./html/tracks.html"
    },


    ]
}

let testPlaylist2 = {
    "id": 2,
    "name": "Rock",
    "description": "Rock 'n Roll for the Soul",
    "artwork": rock,
    "tracks": [{
        "id": 1,
        "name": "One Love",
        "album": "Exodus",
        "duration": 5,
        "lyrics": "One love, one heart, lets get together and feel alright...",
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
        "name": "One Love",
        "album": "Exodus",
        "duration": 5,
        "lyrics": "One love, one heart, lets get together and feel alright...",
        "trackURL": "./html/tracks.html"
    }]
}


let playlistsArray = [testPlaylist1, testPlaylist2, testPlaylist3];
let playlists = document.querySelector("div#playlistCards");

console.log(playlistsArray[0]);
for (let i = 0; i < playlistsArray.length; i++) {

    //Generate DOM elements
    let card = document.createElement("div");
    card.setAttribute("id", "card")
    card.style.backgroundImage = `url(${playlistsArray[i].artwork})`;


    // Playlist Title
    let playlistName = document.createElement("a")
    playlistName.setAttribute("id", "playlistName")
    playlistName.innerText = playlistsArray[i].name;
    playlistName.href = "./html/individualPlaylist.html"

    // Create new line
    let line = document.createElement("br");

    // Playlist Desc
    let playlistDesc = document.createElement("p")
    playlistDesc.setAttribute("id", "playlistDesc")
    playlistDesc.href = playlistsArray[i]

    playlistDesc.innerText = playlistsArray[i].description

    card.appendChild(playlistName);
    card.appendChild(line);
    card.appendChild(playlistDesc);


    playlists.appendChild(card);


}




