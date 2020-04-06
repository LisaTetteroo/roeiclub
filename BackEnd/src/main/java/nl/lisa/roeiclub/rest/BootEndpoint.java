package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.BootService;
import nl.lisa.roeiclub.domein.Boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BootEndpoint {
    @Autowired
    BootService bs;

    @GetMapping("/botenInzien")
    public Iterable<Boot> botenInzien() {
        System.out.println("in botenInzien in bootEndpoint");
        return bs.botenInzien();
    }

    @PostMapping("/bootToevoegen")
    public String bootToevoegen (@RequestBody Boot boot) {
        System.out.println("in bootToevoegen in bootEndpoint: " + boot.getNaam());
        bs.bootToevoegen(boot);
        return "boot naar backend gelukt";
    }

    @DeleteMapping("/bootVerwijderen")
    public String bootVerwijderen (@RequestBody Boot boot) {
        System.out.println("in bootVerwijderen in bootEndpoint: " + boot.getNaam());
        bs.bootVerwijderen(boot.getId(), boot);
        return "boot verwijderd";
    }


}
