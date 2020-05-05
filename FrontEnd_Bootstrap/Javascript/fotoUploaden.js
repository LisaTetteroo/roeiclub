function uploadFoto() {
    alert("testButton upload Foto");

    var file = document.getElementById("fotoBestand").value;

    var formData = new FormData();
    formData.append("file", file);

    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        console.log(this.responseText);
    }

    xhr.open("POST", "http://localhost:8082/fotoUploaden", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(formData);

}

