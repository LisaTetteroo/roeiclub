function tabelPalenInzienVullen() {
    var tabel = document.getElementById("tabelPalenInzien");      
    var rijenAanwezig = document.getElementsByTagName("tr");
    while (1 < rijenAanwezig.length) {
        tabel.deleteRow(-1)
    }

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