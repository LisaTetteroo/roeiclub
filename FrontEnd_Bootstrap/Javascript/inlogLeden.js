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
                    var accountId = account.id;
                    console.log(accountId);
                    localStorage.setItem("accountId", accountId);
                    console.log("terughalen: " + localStorage.getItem("accountId"));
                    location.replace("./ledenPortaal.html")
                }
            } else {
                console.log("VERSTUREN IS NIET GELUKT!");
                alert("gebruikersnaam of wachtwoord is onjuist");
            }
        }
    }

    /*xhr.onreadystatechange = function(){

        if (xhr.readyState === XMLHttpRequest.DONE) {
        
            if (xhr.status === 'OK' || (xhr.status >= 200 && xhr.status < 400)) {
        
                var inhoudDB = JSON.parse(this.responseText);
                console.log("VERSTUREN GELUKT!");
        
                if (inhoudDB.gebruikerType === "Medewerker") {
                    console.log("Je bent een medewerker.");
                    window.location.href = 'medewerker/dashboard.html';
                } else if (inhoudDB.gebruikerType === "Admin") {
                    console.log("Je bent een admin.");
                    window.location.href = 'admin/dashboard.html';

                } else {
                    alert("who are you?");
                }

            } else {
                console.log("VERSTUREN IS NIET GELUKT!");
                alert("emailadres of wachtwoord is onjuist");
            }
        }
    }*/

    xhr.open("Get", "http://localhost:8082/inloggenLeden/" + gebruikersnaam + "-" + wachtwoord, true);
    /*xhr.setRequestHeader("Authorization", "Basic " + btoa(gebruikersnaam + ":" + wachtwoord));*/
    xhr.send();
}

/*"http://localhost:8082/accountBijGebruikersnaamOpvragen/"+gebruikersnaam*/