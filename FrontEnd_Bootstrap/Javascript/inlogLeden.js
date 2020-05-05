function inloggen () {
    var gebruikersnaam = document.getElementById("invoerGebruikersnaam").value;
    console.log(gebruikersnaam)

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var account = JSON.parse(this.responseText);
            console.log(account);
            var accountId = account.id;
            console.log(accountId);
            sessionStorage.setItem("accountId", accountId);
            console.log("terughalen: " + sessionStorage.getItem("accountId"));
            location.replace("./ledenPortaal.html")
        }
    }
    xhr.open("Get", "http://localhost:8082/accountBijGebruikersnaamOpvragen/"+gebruikersnaam, true);
    xhr.send();
}