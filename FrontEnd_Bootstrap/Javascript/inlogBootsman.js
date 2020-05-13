function inloggen () {
    var gebruikersnaam = document.getElementById("invoerGebruikersnaam").value;
    console.log(gebruikersnaam);
    var wachtwoord = document.getElementById("invoerWachtwoord").value;
    console.log(wachtwoord);

    localStorage.setItem("gebruikersnaam", gebruikersnaam);
    localStorage.setItem("wachtwoord",wachtwoord);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (xhr.status === 'OK' || (xhr.status >= 200 && xhr.status < 400)) {
                var account = JSON.parse(this.responseText);
                console.log(account);
                if (account.gebruikersnaam === "fout") {
                    alert("gebruikersnaam of wachtwoord onjuist")
                } else {
                    location.replace("./bootsmanPortaal.html")
                }
            } else {
                console.log("VERSTUREN IS NIET GELUKT!");
                alert("gebruikersnaam of wachtwoord is onjuist");
            }
        }
    }

    xhr.open("Get", "http://localhost:8082/inloggenBootsman/" + gebruikersnaam + "-" + wachtwoord, true);
    xhr.send();
}

