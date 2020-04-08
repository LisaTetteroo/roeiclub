package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.BootService;
import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Palen;
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
        bs.bootVerwijderen(boot.getId());
        return "boot verwijderd";
    }

    @DeleteMapping("/bootverwijderen/{bootId}")
    public String bootVerwijderenPath(@PathVariable long bootId) {
        System.out.println("verwijder path " +bootId);
        bs.bootVerwijderen(bootId);
        return "verwijderen geslaagd path";
    }

    @DeleteMapping("/bootVerwijderenreq")
    public String booterwijderenReq(@RequestParam long bootId) {
        System.out.println("verwijder req" + bootId);
        bs.bootVerwijderen(bootId);
        return "verwijderen geslaagd req";
    }

    @GetMapping("/beschikbareBoten")
    public void beschikbareBoten () {
        bs.beschikbareBoten();
    }

    @GetMapping("/test")
    public void main () {
        bs.probeersel();
    }

}
