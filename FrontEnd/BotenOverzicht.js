function bootToevoegen(){
    var bootObject = {};
    bootObject.naam = document.getElementById("invoerNaam").value;
    bootObject.type = document.getElementById("invoerType").value;
    bootObject.beschikbaar = document.getElementById("invoerBeschikbaar").checked;   
    bootObject.gebruikType = document.querySelector('input[name = gebruikType]:checked').value;
    bootObject.loodsNummer = document.getElementById("invoerLoodsNummer").value;
    bootObject.palenId = document.getElementById("invoerPalenId").value;
    bootObject.aanvullendeInformatie = document.getElementById("invoerAanvullendeInformatie").value;

    var bootJSON = JSON.stringify(bootObject);
    console.log(bootObject);
    console.log(bootJSON);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.responseText);
    }
    xhr.open("POST", "http://localhost:8082/bootToevoegen", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(bootJSON);
}

/*
    if (document.getElementById("invoerBeschikbaar").checked == true) {
        bootObject.beschikbaar = true;
    } else {
        bootObject.beschikbaar =false;
    }
*/