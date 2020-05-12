function inlogcheck() {
    if (localStorage.getItem("gebruikersnaam") !== "admin") {
        alert("niet proberen een omweg te nemen, eerst inloggen")
        location.replace("./inlogBootsman.html")
    }
}