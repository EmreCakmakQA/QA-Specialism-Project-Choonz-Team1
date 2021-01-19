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

function getInfo() {
    varusername = document.getElementById("username").value
    varpassword = document.getElementById("password").value

    for (i = 0; i < objPeople.length; i++) {
        if (username == objPeople[i].username && password == objPeople[i].password) {
            console.log(username + " is logged in.")
            return
        }

    } console.log("failed login")
}


    // <form>
    //     <input id = "username" type="text"  name= "j_username" >
    //     <input id = "password" type="password"  name= "j_password" >
    //     <button type = "button" onclick="getInfo()">submit</button>
    // </form> 
