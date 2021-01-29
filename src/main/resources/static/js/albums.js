// const params = new URLSearchParams(window.location.search);

// // Obtains ID and passes it as a parameter to getData()
// for (let param of params) {
//     console.log("Object ID: " + param)
//     let id = param[1];
//     console.log(id);
//     getData(id)
// }


// function getData(id) {
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
//                     console.log(data)

//                     displayPlaylist(data)

//                 });
//             }
//         )
//         .catch(function (err) {
//             console.log('Fetch Error :-S', err);
//         });
// }


// let rock = "../img/rock.png"


// // Artist Read
// fetch('http://localhost:8082/albums/read/')
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
//                 displayData(data)
//             });
//         }
//     )
//     .catch(function (err) {
//         console.log('Fetch Error :-S', err);
//     });

// function displayData(data) {
//     let div = document.querySelector("div#albums")

//     for (album of data) {


//         let albumName = document.createElement("p")
//         albumName.innerText

//         let artist = document.createElement("p")
//         artist.innerText = data.artist.name

//     }
//     div.appendChild(list)


// }

