function accountToevoegen() {
   
    var accountObject = {};
    accountObject.lid = document.getElementById("invoerLidnummer").value;
    accountObject.gebruikersnaam = document.getElementById("invoerGebruikersnaamAanmaken").value;
    accountObject.wachtwoord = document.getElementById("invoerWachtwoordAanmaken").value;

    var accountJSON = JSON.stringify(accountObject);
    console.log(accountObject);
    console.log(accountJSON);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.responseText);
        document.getElementById("toevoegMessageAccount").innerHTML = this.responseText;
    }

    xhr.open("POST", "http://localhost:8082/accountToevoegen", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(accountJSON);
}
