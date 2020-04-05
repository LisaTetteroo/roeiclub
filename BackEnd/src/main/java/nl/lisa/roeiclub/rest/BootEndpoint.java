package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.BootService;
import nl.lisa.roeiclub.domein.Boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootEndpoint {
    @Autowired
    BootService bs;

    @PostMapping("/bootToevoegen")
    public String bootToevoegen (@RequestBody Boot boot) {
        System.out.println("in bootToevoegen in bootEndpoint: " + boot.getNaam());
        bs.bootToevoegen(boot);
        return "boot naar backend gelukt";
    }

}
