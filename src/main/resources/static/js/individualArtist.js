const params = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    let id = param[1];
    console.log(id);
    getData(id)
}

function getData(id) {
    fetch('http://localhost:8082/artists/read/' + id)
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

let div = document.querySelector("div#artist")
function displayTrack(data) {
    let name = document.createElement("p")
    let tracksUl = document.createElement("ul")
    let tracksLi = document.createElement("li")

    let albumUl = document.createElement("ul")


    name.innerText = data.name;

    if (data.albums.length != 0) {
        for (album of data.albums) {
            let albumsLi = document.createElement("li")
            albumsLi.innerText = album.name
            albumUl.appendChild(albumsLi)
        }
    }


    div.appendChild(name)
    div.appendChild(albumUl)
    div.appendChild()

}

// Get the artist associated with this track by reading albums
// function getArtist(data) {
//     let id = data.album.id
//     console.log(id)
//     fetch('http://localhost:8082/albums/read/' + id)
//         .then(
//             function (response) {
//                 if (response.status !== 200) {
//                     console.log('Looks like there was a problem. Status Code: ' +
//                         response.status);
//                     return;
//                 }
//                 // Examine the text in the response
//                 response.json().then(function (data) {

//                     let artistName = document.createElement("p")
//                     artistName.innerText = data.artist.name
//                     div.appendChild(artistName)



//                 });
//             }
//         )
//         .catch(function (err) {
//             console.log('Fetch Error :-S', err);
//         });
// }