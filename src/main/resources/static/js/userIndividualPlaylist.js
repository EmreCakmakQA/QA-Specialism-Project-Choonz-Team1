const params = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    let id = param[1];
    getData(id)
}

// Captures data for later use in POST method
let arr = []
let playlistID;
let playlistName;
let playlistDesc;

function getData(id) {
    fetch('http://localhost:8082/playlists/read/' + id)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                response.json().then(function (data) {
                    console.log(data)

                    // Assign playlist info for POST method later in code
                    playlistID = data.id
                    playlistName = data.name
                    playlistDesc = data.description

                    displayPlaylist(data)

                    // Pushes tracks objects to array
                    for (let i = 0; i < data.tracks.length; i++) {
                        arr.push(data.tracks[i])
                    }

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
        let deleteBtn = document.createElement("button")

        btn.innerText = "View"
        deleteBtn.innerText = "Delete"


        // View Button
        btn.setAttribute("class", "btn btn-primary btn-sm")
        btn.onclick = () => {

            console.log("view")
            location.href = `individualTrack.html?id=${data.tracks[i].id}`
        }

        // Delete Button
        deleteBtn.setAttribute("class", "btn btn-danger btn-sm")
        deleteBtn.onclick = () => {

            delete arr[i];

            let dataToSend = {
                "id": playlistID,
                "name": playlistName,
                "description": playlistDesc,
                "tracks": arr
            }
            sendData(dataToSend)


        }


        list.appendChild(track)
        list.appendChild(btn)
        list.appendChild(deleteBtn)

    }

    div.appendChild(list)

}


function sendData(data) {
    fetch("http://localhost:8082/playlists/update/" + playlistID, {
        method: 'put',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(data)
    })
        .then(function (data) {
            console.log('Request succeeded with JSON response', data);
            location.reload()


        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}




