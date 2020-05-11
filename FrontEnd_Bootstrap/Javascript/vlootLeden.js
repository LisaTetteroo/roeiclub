function tabelPalenInzienVullen() {
    var tabel = document.getElementById("tabelPalenInzien");      
    var rijenAanwezig = document.getElementsByTagName("tr");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var palen = JSON.parse(this.responseText);
            console.log(palen);
            for (var i = 0 ; i < palen.length ; i++) {
                var rij = tabel.appendChild(tabel.insertRow());
                var celId = rij.insertCell(0);
                celId.innerHTML = palen[i].id;
                var celSoort = rij.insertCell();
                celSoort.innerHTML = palen[i].soort;
                var celLocatie = rij.insertCell();
                celLocatie.innerHTML = palen[i].locatie;
                var celAantal = rij.insertCell();
                celAantal.innerHTML = palen[i].aantal;
                var celToekenning = rij.insertCell();
                celToekenning.innerHTML = palen[i].toekenning;
            }
        }
    }

    xhr.open("GET", "http://localhost:8082/palenInzien", true);
    xhr.send();
}

function tabelBotenInzienVullenLeden() {
    var tabel = document.getElementById("tabelBotenInzienLeden");      
    var rijenAanwezig = document.getElementsByTagName("tr");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var boot = JSON.parse(this.responseText);
            console.log(boot);
            for (var i = 0 ; i < boot.length ; i++) {
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
                console.log(boot[i].palen)
                celPalenId.innerHTML = boot[i].palen.id;
                var celAanvullendeInformatie = rij.insertCell();
                celAanvullendeInformatie.innerHTML = boot[i].aanvullendeInformatie;               
            }
        }  
    }
    xhr.open("GET", "http://localhost:8082/botenInzien", true);
    xhr.send();
}
