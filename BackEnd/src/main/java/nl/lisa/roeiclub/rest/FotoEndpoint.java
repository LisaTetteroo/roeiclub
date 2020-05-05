package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.LidService;
import nl.lisa.roeiclub.domein.Foto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FotoEndpoint {
    @Autowired
    LidService ls;

    @PostMapping("/fotoUploaden")
    public void fotoUploaden(@RequestParam("file") MultipartFile file, @RequestParam String idString)throws IOException {
        Long idLong = Long.parseLong(idString);
        ls.fotoToevoegen(file, idLong);
    }
}

