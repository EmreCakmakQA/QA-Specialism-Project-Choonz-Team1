const params = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    let id = param[1];
    console.log(id);
    getData(id)
}

function getData(id) {
    fetch('http://localhost:8082/tracks/read/' + id)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                // Examine the text in the response
                response.json().then(function (data) {
                    console.log("MY DATA OBJ", data)

                    displayTrack(data);


                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}

let div = document.querySelector("div#track")
function displayTrack(data) {
    let title = document.createElement("p")
    let artist = document.createElement("p")
    let album = document.createElement("p")
    let genre = document.createElement("p")
    let lyrics = document.createElement("p")

    title.innerText = data.name;
    //artist = ?
    album.innerText = data.album.name;
    //genre = ?
    lyrics.innerText = data.lyrics

    div.appendChild(title)
    div.appendChild(album)

    getArtist(data)

    div.appendChild(lyrics)

}

// Get the artist associated with this track by reading albums
function getArtist(data) {
    let id = data.album.id
    console.log(id)
    fetch('http://localhost:8082/albums/read/' + id)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                // Examine the text in the response
                response.json().then(function (data) {

                    let artistName = document.createElement("p")
                    artistName.innerText = data.artist.name
                    div.appendChild(artistName)



                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}