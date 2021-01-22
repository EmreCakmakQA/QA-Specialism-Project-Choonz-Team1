const params = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    let id = param[1];
    console.log(id);
    getData(id)
}


function getData(id) {
    fetch('http://localhost:8082/playlists/read/' + id)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                // Examine the text in the response
                response.json().then(function (data) {
                    console.log(data)

                    displayPlaylist(data)

                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}

function displayPlaylist(data) {

    let div = document.querySelector("div#playlist")

    let heading = document.querySelector("h1#heading")
    heading.innerText = data.name

    let desc = data.description
    let description = document.createElement("p")
    description.innerText = desc

    div.appendChild(description)

    let list = document.createElement("ul");

    for (let i = 0; i < data.tracks.length; i++) {
        trackName = data.tracks[i].name

        let track = document.createElement("li")
        track.innerText = trackName

        let btn = document.createElement("button")
        btn.innerText = "view"
        btn.setAttribute("class", "btn btn-primary btn-sm")
        btn.onclick = () => {
            console.log(data.tracks[i].id)
            location.href = `individualTrack.html?id=${data.tracks[i].id}`
        }


        list.appendChild(track)
        list.appendChild(btn)

    }

    div.appendChild(list)

}

