function bootToevoegen(){
    var bootObject = {};
    bootObject.id = document.getElementById("bootId").value;
    bootObject.naam = document.getElementById("invoerNaam").value;
    bootObject.type = document.getElementById("invoerType").value;
    bootObject.beschikbaar = document.getElementById("invoerBeschikbaar").checked;   
    bootObject.gebruikType = document.querySelector('input[name = gebruikType]:checked').value;
    bootObject.loodsNummer = document.getElementById("invoerLoodsNummer").value;     
    bootObject.palen = document.getElementById("invoerPalen").value;
    bootObject.aanvullendeInformatie = document.getElementById("invoerAanvullendeInformatie").value;

    var bootJSON = JSON.stringify(bootObject);
    console.log(bootObject);
    console.log(bootJSON);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.responseText);
        document.getElementById("toevoegMessageBoot").innerHTML = this.responseText;
        if (this.readyState == 4) {
            tabelBotenInzienVullen();
        }
    }

    xhr.open("POST", "http://localhost:8082/bootToevoegen", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(bootJSON);    
}

function tabelBotenInzienVullen() {
    if (localStorage.getItem("gebruikersnaam") !== "admin") {
        alert("niet proberen een omweg te nemen, eerst inloggen")
        location.replace("./inlogBootsman.html")
    }

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
            console.log(boot);
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
                console.log(boot[i].palen)
                celPalenId.innerHTML = boot[i].palen.id;
                var celAanvullendeInformatie = rij.insertCell();
                celAanvullendeInformatie.innerHTML = boot[i].aanvullendeInformatie;                    
                var celVerwijderBoot = rij.insertCell();
                createButtonVerwijder(boot[i].id, boot[i].naam, celVerwijderBoot);
                var celUpdateBoot = rij.insertCell();
                createButtonUpdate(boot[i].id, celUpdateBoot);
                
            }
        }  
    }
    xhr.open("GET", "http://localhost:8082/botenInzien", true);
    xhr.send();        
}

function createButtonVerwijder (id, naam, cel) {
    var buttonVerwijderBoot = document.createElement("button");
    buttonVerwijderBoot.id = id;
    buttonVerwijderBoot.className = "btn-outline-paars";
    buttonVerwijderBoot.innerHTML = "verwijder boot";
    buttonVerwijderBoot.onclick = function () {
        verwijderBoot(id, naam);
    }
    cel.appendChild(buttonVerwijderBoot);

}

function createButtonUpdate (id, cel) {
    var buttonUpdateBoot = document.createElement("button");
    buttonUpdateBoot.id = id;
    buttonUpdateBoot.className = "btn-outline-paars"
    buttonUpdateBoot.innerHTML = "gegevens aanpassen";
    buttonUpdateBoot.onclick = function () {
        bootUpdatenVullen(id);
    }
    cel.appendChild(buttonUpdateBoot);
}


function verwijderBoot (bootId, bootNaam) {
    //console.log("test verwijder boot button " + bootId);
    if (confirm("Weet je zeker dat je de " + bootNaam + " wil verijderen? Dit kan niet ongedaan gemaakt!")) {
            if (confirm("Sorry, dubbelcheck: Weet je zeker dat je de " + bootNaam + " wil verijderen? Dit kan niet ongedaan gemaakt!")) {
            var boot = {};
            boot.id = bootId;
            var bootJSON = JSON.stringify(boot);
            
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                console.log(this.responseText);
                if (this.readyState == 4) {
                    alert(this.responseText);
                    tabelBotenInzienVullen();
                }
            }
            xhr.open("DELETE", "http://localhost:8082/bootVerwijderen", true);
            xhr.setRequestHeader("Content-type", "application/json");
            xhr.send(bootJSON);
        }
    }
}



function bootUpdatenVullen (bootId) {
    console.log("test button update vullen" + bootId)

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            var boot = JSON.parse(this.responseText);
            for (var i = 0 ; i < boot.length ; i++) {
                if (boot[i].id == bootId) {
                    //console.log(boot[i]);
                    document.getElementById("bootId").value = boot[i].id;
                    console.log(boot[i].naam);
                    document.getElementById("invoerNaam").value = boot[i].naam;
                    document.getElementById("invoerType").value = boot[i].type;
                    document.getElementById("invoerBeschikbaar").checked = boot[i].beschikbaar;
                    document.getElementById("invoerLoodsNummer").value = boot[i].loodsNummer;
                    document.getElementById("invoerPalen").value = boot[i].palen.id;
                    document.getElementById("invoerAanvullendeInformatie").value = boot[i].aanvullendeInformatie;
                    if (boot[i].gebruikType === "compo") {
                        document.getElementById("gebruikTypeCompo").checked = true;
                    } else if (boot[i].gebruikType === "wedstro") {
                        document.getElementById("gebruikTypeWedstro").checked = true;
                    } else if (boot[i].gebruikType === "prive") {
                        document.getElementById("gebruikTypePrive").checked = true;
                    }
                }
            }

        } 
    }
    xhr.open("GET", "http://localhost:8082/botenInzien", true);
    xhr.send(); 
}

function bootUpdaten() {
        var bootObject = {};
        bootObject.id = document.getElementById("bootId").value;
        bootObject.naam = document.getElementById("invoerUpdateNaam").value;
        bootObject.type = document.getElementById("invoerType").value;
        bootObject.beschikbaar = document.getElementById("invoerBeschikbaar").checked;   
        bootObject.gebruikType = document.querySelector('input[name = gebruikType]:checked').value;
        bootObject.loodsNummer = document.getElementById("invoerLoodsNummer").value;
        //bootObject.palenId = document.getElementById("invoerPalenId").value;
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