let objPeople = []    

function createUserArray (data) {
    for (let i = 0; i < data.length; i++) {

        let username = data[i].name
        let password = data[i].password
        console.log(username, password)
        let user = {
            "username" : username,
            "password" : password
        }
        objPeople.push(user)
   
    }
}

// User Read
fetch('http://localhost:8082/users/read/')
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
            //    displayData(data)
            console.log("call createUserArray")
            createUserArray (data)
            console.log(objPeople)
            });
        }
    )
    .catch(function (err) {
        console.log('Fetch Error :-S', err);
    });

document.addEventListener("submit", (e) => {
    e.preventDefault()
    let username = document.querySelector("input#username").value
    console.log(username)
    let password = document.querySelector("input#password").value
    console.log(password)

    let div = document.querySelector("div#success")
    div.innerText = ''

    for (i = 0; i < objPeople.length; i++) {
        console.log(objPeople[i].username, "this is the new user")
        if (username == objPeople[i].username && password == objPeople[i].password) {

            let success = document.createElement("p")
            success.innerText = "Login Successful!"
            success.setAttribute("class", "p-3 mb-2 bg-success text-white")
            div.appendChild(success)
            setTimeout(() => {
                location.href = "/index.html";
            }, 3000);
            return


        } else if (i == (objPeople.length-1) && (username != objPeople[i].username || password == objPeople[i].password)) {

            let success = document.createElement("p")
            success.innerText = "Incorrect password or username"
            success.setAttribute("class", "p-3 mb-2 bg-danger text-white")
            div.appendChild(success)
            setTimeout(() => {
                div.innerText = "";
            }, 3000);
        } 
    }

})


