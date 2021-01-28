



////////////////////////////////////////////////////////////////


let reggae = "./img/reggae.png"
let rock = "./img/rock.png"
let pop = "./img/pop.png"

// Playlist Read
fetch('http://localhost:8082/tracks/read/')
    .then(
        function (response) {
            if (response.status !== 200) {
                console.log('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response
            response.json().then(function (data) {

                displayData(data)
            });
        }
    )
    .catch(function (err) {
        console.log('Fetch Error :-S', err);
    });



let playlists = document.querySelector("div#playlistCards");




function displayData(data) {


    for (let i = 0; i < data.length; i++) {
        console.log(data[i])

        let playlistCard = document.createElement("div");
        playlistCard.style.background = `url(${rock})`
        playlistCard.setAttribute("id", "card")

        let trackName = data[i].name;
        console.log(trackName)

        let name = document.createElement("a");
        let id = data[i].id
        console.log(id)
        //name.href = "html/individualPlaylist.html?id=" + id

        




        let description = document.createElement("p")
        let desc = document.createElement("p")
        let aname = document.createElement("p")
        name.setAttribute("id", "trackName")
        description.setAttribute("id", "playlistDesc")
        desc.setAttribute("id", "genDesc")
        aname.setAttribute("id", "genDesc")

        name.innerText = "Track name: "+trackName
        description.innerText = "Album name: "+data[i].album.name
        desc.innerText ="Genre: "+data[i].genre.name
        aname.innerText ="Artist: "+data[i].artist.name

        playlistCard.appendChild(name)
        playlistCard.appendChild(description)
        playlistCard.appendChild(desc)
        playlistCard.appendChild(aname)
        playlists.appendChild(playlistCard)


    }

}






