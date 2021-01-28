let rock = "../img/rock.png"


// Artist Read
fetch('http://localhost:8082/artists/read/')
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
                displayData(data)
            });
        }
    )
    .catch(function (err) {
        console.log('Fetch Error :-S', err);
    });



let artists = document.querySelector("div#artistCards");




function displayData(data) {


    for (let i = 0; i < data.length; i++) {
        //console.log(data[i])

        let artistCard = document.createElement("div");
        artistCard.style.background = `url(${rock})`
        artistCard.setAttribute("id", "card")

        let artistName = data[i].name;
        console.log(artistName)

        let name = document.createElement("a");
        // let id = data[i].id
        // console.log(id)
        // name.href = "html/individualArtist.html?id=" + id

        let albumName = document.createElement("p")

        name.setAttribute("id", "playlistName")
        albumName.setAttribute("id", "playlistDesc")

        name.innerText = artistName

        artistCard.appendChild(name)
        artists.appendChild(artistCard)


    }

}






