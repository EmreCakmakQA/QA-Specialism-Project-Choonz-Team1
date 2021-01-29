const params = new URLSearchParams(window.location.search);
let userID;
let userName;
let userPassword;
let playlistToSend;

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    userID = param[1];
    console.log(userID);
    //getData(id)
}




let tracksArr = []
let formOptions = document.querySelector("select#formOptions")



document
    .querySelector("form.viewRecord")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();
        let formElements = document.querySelector("form.viewRecord").elements;
        console.log(formElements)


        let name = formElements["name"].value;
        let description = formElements["description"].value;

        let playlist = {

            "name": name,
            "description": description

        }


        //console.log("Data to post", playlist)
        sendData(playlist)
    });

function sendData(data) {
    fetch("http://localhost:8082/playlists/create/", {
        method: 'post',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(data)
    })
        .then(function (data) {
            console.log('Request succeeded with JSON response', data);
            console.log(userID)
            let p = document.querySelector("p#success")
            p.innerText = "Successfully created playlist"
            p.setAttribute("class", "success")
            readPlaylist(data)

            readUser(userID)


            console.log(playlistToSend)
            //updatePlaylist(playlistToSend, playlistId)

        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}




function updatePlaylist(playlist) {

    fetch("http://localhost:8082/playlists/update/" + playlistToSend.id, {
        method: 'put',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(playlist)
    })
        .then(function (data) {
            // console.log('Request succeeded with JSON response', data);
            // console.log("playlist created")



        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}


function readPlaylist() {
    fetch('http://localhost:8082/playlists/read/')
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }

                // Examine the text in the response
                response.json().then(function (data) {
                    let playlist = data.slice(-1).pop()
                    // console.log(playlist)
                    // console.log(userID)

                    playlistToSend = {
                        "id": playlist.id,
                        "name": playlist.name,
                        "description": playlist.description,
                        "user": {
                            "id": userID,
                            "name": userName,
                            "password": userPassword
                        },
                        "tracks": []
                    }

                    return playlistToSend;


                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}

function readUser(userID) {
    fetch('http://localhost:8082/users/read/' + userID)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }

                // Examine the text in the response
                response.json().then(function (data) {
                    userName = data.name
                    userPassword = data.password

                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}


