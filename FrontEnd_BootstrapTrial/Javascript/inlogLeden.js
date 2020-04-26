function saveId () {
    //sessionStorage.setItem("accountId", 0);
    var gebruikersnaam = document.getElementById("invoerGebruikersnaamLid").value;
    console.log(gebruikersnaam)
    //var account = {}
    //account.gebruikersnaam = gebruikersnaam;
    //var gebruikersnaamJSON = JSON.stringify(gebruikersnaam);
    //console.log(gebruikersnaamJSON)

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var account = JSON.parse(this.responseText);
            console.log(account);
            var accountId = account.id;
            console.log(accountId);
            sessionStorage.setItem("accountId", accountId);
            console.log("terughalen: " + sessionStorage.getItem("accountId"));
        }
    }
    xhr.open("Get", "http://localhost:8082/accountBijGebruikersnaamOpvragen/"+gebruikersnaam, true);
    xhr.send();
}