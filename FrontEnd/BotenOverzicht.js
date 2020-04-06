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
    var tabel = document.getElementById("tabelBotenInzien");      
    var rijenAanwezig = document.getElementsByTagName("tr");
    while (1 < rijenAanwezig.length) {
        tabel.deleteRow(-1)
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var boot = JSON.parse(this.responseText);
            for (var i = 0 ; i < boot.length ; i++) {
                //document.getElementById("testBotenInzien").innerHTML += boot[i].naam + "<br>";
                var rij = tabel.appendChild(tabel.insertRow());
                var celId = rij.insertCell(0);
                celId.innerHTML = boot[i].id;
                var celNaam = rij.insertCell();
                celNaam.innerHTML = boot[i].naam;
                var celType = rij.insertCell();
                celType.innerHTML = boot[i].type;
                var celBeschikbaar = rij.insertCell();
                celBeschikbaar.innerHTML = boot[i].beschikbaar;
                var celGebruikType = rij.insertCell();
                celGebruikType.innerHTML = boot[i].gebruikType;
                var celLoodsNummer = rij.insertCell();
                celLoodsNummer.innerHTML = boot[i].loodsNummer;
                var celPalenId = rij.insertCell();
                celPalenId.innerHTML = boot[i].palenId;
                var celAanvullendeInformatie = rij.insertCell();
                celAanvullendeInformatie.innerHTML = boot[i].aanvullendeInformatie;                    
                
                var celVerwijderBoot = rij.insertCell();
                
                var ButtonVerwijderBoot = document.createElement("button");
                 
                ButtonVerwijderBoot.value = i;
                ButtonVerwijderBoot.innerHTML = "verwijder boot";
                ButtonVerwijderBoot.onclick = function () {
                    verwijderBoot(boot[i].id);
                } 
                console.log(ButtonVerwijderBoot.value);
                var addButtonVerwijderBoot= celVerwijderBoot.appendChild(ButtonVerwijderBoot);
            }
        }  
    }
    xhr.open("GET", "http://localhost:8082/botenInzien", true);
    xhr.send();        
}

function createButton (i) {
    var buttonVerwijderBoot = document.createElement("button");
    buttonVerwijderBoot.value = i;
}

function verwijderBoot (n) {
    var tabel = document.getElementById("tabelBotenInzien");
    console.log("test verwijder boot button" + n);
}