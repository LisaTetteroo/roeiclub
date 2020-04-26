function tabelRerserverenVullen() {
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
            test();
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
                var celReserveerBoot = rij.insertCell();
                createButtonReserveer(boot[i].id, celReserveerBoot);
            }
        }  
    }
    xhr.open("GET", "http://localhost:8082/botenInzien", true);
    xhr.send();
}

function createButtonReserveer (id, cel) {
    var buttonReserveren = document.createElement("button");
    buttonReserveren.id = id;
    buttonReserveren.className = "btn-outline-paars";
    buttonReserveren.innerHTML = "Reserveren";
    buttonReserveren.onclick = function () {
        bootReserveren(id);
    }
    cel.appendChild(buttonReserveren);
}

function bootReserveren (bootId) {
    var accountId = sessionStorage.getItem("accountId");
    var datumReservering = document.getElementById("datumReservering").value;
    var startTijdReservering = document.getElementById("startTijdReservering").value;
    var eindTijdReservering = document.getElementById("eindTijdReservering").value;
    console.log(accountId)
    console.log("reserveren van bootid:" + bootId + "door accountId: "+ accountId + "op datum: " + datumReservering + "starttijd: " +startTijdReservering + "Eindtijd: " +eindTijdReservering);

    var xhr = new XMLHttpRequest;
    xhr.onreadystatechange = function () {
    }
    xhr.open("post", "http://localhost:8082/reserveringMakenreq?bootIdParam="+bootId+"&accountIdParam="+accountId+"&datumReserveringParam="+datumReservering+"&startTijdParam="+startTijdReservering+"&eindTijdParam="+eindTijdReservering, true);
    xhr.send();
}

function test () {
    console.log(sessionStorage.getItem("accountId"))
}