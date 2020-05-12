function inlogcheck() {
    if (localStorage.getItem("gebruikersnaam") === null) {
        alert("niet proberen een omweg te nemen, eerst inloggen")
        location.replace("./inlogLeden.html")
    }
}