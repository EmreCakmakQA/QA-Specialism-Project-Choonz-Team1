const params = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    let id = param[1];
    console.log(id);
    //getData(id)
}


// function getData(id) {

//     fetch('http://localhost:8082/users/read/' + id)
//         .then(
//             function (response) {
//                 if (response.status !== 200) {
//                     console.log('Looks like there was a problem. Status Code: ' +
//                         response.status);
//                     return;
//                 }
//                 // Examine the text in the response
//                 response.json().then(function (data) {
//                     //console.log(data)

//                     displayPlaylists(data.playlists)

//                 });
//             }
//         )
//         .catch(function (err) {
//             console.log('Fetch Error :-S', err);
//         });
// }