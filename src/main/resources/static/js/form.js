let objPeople = [
    {
        username: "sam",
        password: "password1"
    },
    {
        username: "dave",
        password: "password2"
    },
    {
        username: "chris",
        password: "password3"

    }
]

document.addEventListener("submit", (e) => {
    e.preventDefault()
    let username = document.querySelector("input#username").value
    let password = document.querySelector("input#password").value

    let div = document.querySelector("div#success")
    div.innerText = ''

    for (i = 0; i < objPeople.length; i++) {
        if (username == objPeople[i].username && password == objPeople[i].password) {

            let success = document.createElement("p")
            success.innerText = "Login Successful!"
            success.setAttribute("class", "p-3 mb-2 bg-success text-white")
            div.appendChild(success)
            setTimeout(() => {
                location.href = "/index.html";
            }, 3000);
            return


        } else {

            let success = document.createElement("p")
            success.innerText = "Incorrect password or username"
            success.setAttribute("class", "p-3 mb-2 bg-danger text-white")
            div.appendChild(success)
            setTimeout(() => {
                div.innerText = "";
            }, 3000);
            return
        }
    }

})



