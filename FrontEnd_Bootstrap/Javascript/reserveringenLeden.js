function tabelReserveringenVullen () {
    console.log(sessionStorage.getItem("accountId"))
    
    var accountId = sessionStorage.getItem("accountId");
    console.log(accountId);

    var tabel = document.getElementById("tabelReserveringenInzien");      
    var rijenAanwezig = document.getElementsByTagName("tr");
    while (1 < rijenAanwezig.length) {
        tabel.deleteRow(-1)
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var reserveringen = JSON.parse(this.responseText);
            console.log(reserveringen);
            for (i = 0; i < reserveringen.length; i++) {
                var rij = tabel.appendChild(tabel.insertRow());
                var celId = rij.insertCell(0);
                celId.innerHTML = reserveringen[i].datum;
                var celId = rij.insertCell();
                celId.innerHTML = reserveringen[i].boot.naam;
                var celId = rij.insertCell();
                celId.innerHTML = reserveringen[i].boot.loodsNummer;
                var celId = rij.insertCell();
                celId.innerHTML = reserveringen[i].boot.palen.id;
                var celId = rij.insertCell();
                celId.innerHTML = reserveringen[i].boot.palen.locatie;
                var celId = rij.insertCell();
                celId.innerHTML = reserveringen[i].startTijd;
                var celId = rij.insertCell();
                celId.innerHTML = reserveringen[i].eindTijd;
                var celAnnuleren = rij.insertCell();
                createButtonAnnuleren(reserveringen[i].id, celAnnuleren);
            }
        }
    }
    xhr.open("GET", "http://localhost:8082/reserveringInzienreq?accountIdString="+accountId, true)
    xhr.send()
}

function createButtonAnnuleren (id, cel) {
    var buttonAnnuleren = document.createElement("button");
    buttonAnnuleren.id = id;
    buttonAnnuleren.className = "btn-outline-paars";
    buttonAnnuleren.innerHTML = "Annuleren";
    buttonAnnuleren.onclick = function () {
        reserveringAnnuleren(id);
    }
    cel.appendChild(buttonAnnuleren);
}

function reserveringAnnuleren(reserveringId) {
    //console.log("test verwijder boot button " + bootId);
    if (confirm("Weet je zeker dat je deze reservering wil annuleren?")) {
        var reservering = {};
        reservering.id = reserveringId;
        var reserveringJSON = JSON.stringify(reservering);
        
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            console.log(this.responseText);
            if (this.readyState == 4) {
                alert(this.responseText);
                tabelReserveringenVullen();
            }
        }
        xhr.open("DELETE", "http://localhost:8082/reserveringAnnuleren", true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(reserveringJSON);
        
    }
}
