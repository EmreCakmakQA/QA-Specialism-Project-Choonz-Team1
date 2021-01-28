const params = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    let id = param[1];
    //console.log(id);
    getData(id)
}


function getData(id) {

    fetch('http://localhost:8082/users/read/' + id)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                // Examine the text in the response
                response.json().then(function (data) {
                    //console.log(data)

                    displayPlaylists(data.playlists)

                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}


////////////////////////////////////////////////////////////////



let rock = "../img/rock.png"






let playlists = document.querySelector("div#playlistCards");




function displayPlaylists(data) {


    for (let i = 0; i < data.length; i++) {
        console.log(data)

        let playlistCard = document.createElement("div");
        playlistCard.style.background = `url(${rock})`
        playlistCard.setAttribute("id", "card")

        let playlistName = data[i].name;

        let name = document.createElement("a");
        let playlistID = data[i].id
        console.log(playlistName, playlistID)
        name.href = "userIndividualPlaylist.html?id=" + playlistID





        let description = document.createElement("p")

        name.setAttribute("id", "playlistName")
        description.setAttribute("id", "playlistDesc")

        name.innerText = playlistName
        description.innerText = data[i].description

        playlistCard.appendChild(name)
        playlistCard.appendChild(description)


        playlists.appendChild(playlistCard)


    }

}






