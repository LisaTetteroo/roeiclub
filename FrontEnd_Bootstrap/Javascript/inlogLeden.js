function inloggen () {
    var gebruikersnaam = document.getElementById("invoerGebruikersnaam").value;
    console.log(gebruikersnaam);
    var wachtwoord = document.getElementById("invoerWachtwoord").value;
    console.log(gebruikersnaam);

    localStorage.setItem("gebruikersnaamLid", gebruikersnaam);
    localStorage.setItem("wachtwoordLid",wachtwoord);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (xhr.status === 'OK' || (xhr.status >= 200 && xhr.status < 400)) {
                var account = JSON.parse(this.responseText);
                console.log(account);
                var accountId = account.id;
                console.log(accountId);
                sessionStorage.setItem("accountId", accountId);
                console.log("terughalen: " + sessionStorage.getItem("accountId"));
                location.replace("./ledenPortaal.html")
            } else {
                console.log("VERSTUREN IS NIET GELUKT!");
                alert("emailadres of wachtwoord is onjuist");
            }
        }
    }
    xhr.open("Get", "http://localhost:8082/accountBijGebruikersnaamOpvragen/"+gebruikersnaam, true);
    xhr.setRequestHeader("Authorization", "Basic " + btoa(gebruikersnaam + ":" + wachtwoord));
    xhr.send();
}