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

function botenInzien () {
    //alert("test button boten inzien")
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var BootUitDatabase = JSON.parse(this.responseText);
            for (var i = 0 ; i < BootUitDatabase.length ; i++) {
                document.getElementById("testBotenInzien").innerHTML += BootUitDatabase[i].naam + "<br>";
            }
        }  
    }
    xhr.open("GET", "http://localhost:8082/botenInzien", true);
    xhr.send();


    /*
    var tabel = document.getElementById("tabelBotenInzien");
    var rij = tabel.appendChild(tabel.insertRow());
    var cel1 = rij.insertCell(0);
    var cel2 = rij.insertCell(1);
    var cel3 = rij.insertCell(2);
    */
}

/*
    var veldnamen = tabel.createTHead();
    var veldnamenRij = veldnamen.insertRow(0);
    var veldnamenCel1 = veldnamenRij.insertCell(0);
    var veldnamenCel2 = veldnamenRij.insertCell();
    veldnamenCel1.innerHTML = "<b> cel 1 header </b>"
    veldnamenCel2.innerHTML = "<b> cel 2 header </b>"
*/


/*
    if (document.getElementById("invoerBeschikbaar").checked == true) {
        bootObject.beschikbaar = true;
    } else {
        bootObject.beschikbaar =false;
    }
*/