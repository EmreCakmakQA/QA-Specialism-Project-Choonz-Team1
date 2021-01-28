const params = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    let id = param[1];
    //console.log(id);
    getData(id)
}



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

                //displayPlaylists(data.playlists)
                userID = data.

                });
        }
    )
    .catch(function (err) {
        console.log('Fetch Error :-S', err);
    });



let tracksArr = []
let formOptions = document.querySelector("select#formOptions")



// fetch('http://localhost:8082/tracks/read/')
//     .then(
//         function (response) {
//             if (response.status !== 200) {
//                 console.log('Looks like there was a problem. Status Code: ' +
//                     response.status);
//                 return;
//             }

//             // Examine the text in the response
//             response.json().then(function (data) {
//                 console.log(data)
//                 // for (track of data) {
//                 //     tracksArr.push(track)
//                 //     let option = document.createElement("option")
//                 //     option.innerText = track.name
//                 //     formOptions.appendChild(option)

//                 // }

//             });
//         }
//     )
//     .catch(function (err) {
//         console.log('Fetch Error :-S', err);
//     });



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
        console.log("Data to post", playlist)
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
            //location.href = "html/user.html?id=" + id
            console.log("vrtvtr")



        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}