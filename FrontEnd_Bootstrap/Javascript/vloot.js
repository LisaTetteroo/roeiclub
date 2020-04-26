function tabelBotenInzienVullen() {
    var tabel = document.getElementById("tabelBotenInzien");      
    var rijenAanwezig = document.getElementsByTagName("tr");
    while (1 < rijenAanwezig.length) {
        tabel.deleteRow(-1)
    }

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