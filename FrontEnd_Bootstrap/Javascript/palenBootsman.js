function palenToevoegen() {
    var palenObject = {};
    palenObject.id = document.getElementById("palenId").value;
    palenObject.soort = document.getElementById("invoerSoort").value;
    palenObject.locatie = document.getElementById("invoerLocatie").value;
    palenObject.aantal = document.getElementById("invoerAantal").value;
    palenObject.toekenning = document.getElementById("invoerToekenning").value;

    var palenJSON = JSON.stringify(palenObject);
    console.log(palenObject);
    console.log(palenJSON);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.responseText);
        document.getElementById("toevoegMessagePalen").innerHTML = this.responseText
        if (this.readyState == 4) {
            tabelPalenVullen();
        }
    }

    xhr.open("POST", "http://localhost:8082/palenToevoegen", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(palenJSON);
}

function tabelPalenVullen () {
    //alert("test button boten inzien")
    if (localStorage.getItem("gebruikersnaam") !== "admin") {
        alert("niet proberen een omweg te nemen, eerst inloggen")
        location.replace("./inlogBootsman.html")
    }

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
                //document.getElementById("testPalenInzien").innerHTML += palen[i].soort + "<br>"

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
                var celUpdatePalen = rij.insertCell();
                createButtonUpdate(palen[i].id, celUpdatePalen);
                var celVerwijderPalen = rij.insertCell();
                createButtonVerwijder(palen[i].id, celVerwijderPalen);

            }
        }
    }

    xhr.open("GET", "http://localhost:8082/palenInzien", true);
    xhr.send();
}

function createButtonVerwijder (id, cel) {
    var buttonVerwijderPalen = document.createElement("button");
    buttonVerwijderPalen.id =  id;
    buttonVerwijderPalen.className = "btn-outline-paars";
    buttonVerwijderPalen.innerHTML = "verwijder Palen";
    buttonVerwijderPalen.onclick = function () {
        //alert("verwijderknop" + id)
        verwijderPalen(id);
    }
    cel.appendChild(buttonVerwijderPalen);

}

function createButtonUpdate (id, cel) {
    var buttonUpdatePalen = document.createElement("button");
    buttonUpdatePalen.id =  id;
    buttonUpdatePalen.className = "btn-outline-paars";
    buttonUpdatePalen.innerHTML = "gegevens aanpassen";
    buttonUpdatePalen.onclick = function () {
        //alert("update knop" + id)
        palenUpdatenVullen(id);
    }
    cel.appendChild(buttonUpdatePalen);
}

function verwijderPalen (palenId) {
    if (confirm("Weet je zeker dat je de paal met id " + palenId + " wil verijderen? Dit kan niet ongedaan gemaakt!")) {
        if (confirm("Sorry, dubbelcheck: Weet je zeker dat je de paal met id" + palenId + " wil verijderen? Dit kan niet ongedaan gemaakt!")) {
        
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                console.log(this.responseText);
                if (this.readyState == 4) {
                    alert(this.responseText);
                    tabelPalenVullen();
                }
            }
            xhr.open("DELETE", "http://localhost:8082/palenVerwijderen/" +palenId+ "", true);
            xhr.setRequestHeader("Content-type", "application/json");
            xhr.send();
        }
    }
}

function palenUpdatenVullen(palenId) {
    console.log("test button update vullen" + palenId)

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var palen = JSON.parse(this.responseText);
            for (var i = 0 ; i < palen.length ; i++) {
                if (palen[i].id == palenId) {
                    //console.log(boot[i]);
                    document.getElementById("palenId").value = palen[i].id;
                    document.getElementById("invoerSoort").value = palen[i].soort;
                    document.getElementById("invoerLocatie").value = palen[i].locatie;
                    document.getElementById("invoerAantal").value = palen[i].aantal;
                    document.getElementById("invoerToekenning").value = palen[i].toekenning;
                }
            }

        } 
    }
    xhr.open("GET", "http://localhost:8082/palenInzien", true);
    xhr.send();
}

