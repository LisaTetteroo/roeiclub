package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.VlootService;
import nl.lisa.roeiclub.domein.Boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BootEndpoint {
    @Autowired
    VlootService vs;

    @GetMapping("/botenInzien")
    public Iterable<Boot> botenInzien() {
        System.out.println("in botenInzien in bootEndpoint");
        return vs.botenInzien();
    }

    @PostMapping("/bootToevoegen")
    public String bootToevoegen (@RequestBody Boot boot) {
        System.out.println("in bootToevoegen in bootEndpoint: " + boot.getNaam());
        String message = vs.bootToevoegen(boot);
        return message;
    }

    @DeleteMapping("/bootVerwijderen")
    public String bootVerwijderen (@RequestBody Boot boot) {
        System.out.println("in bootVerwijderen in bootEndpoint: " + boot.getNaam());
        vs.bootVerwijderen(boot.getId());
        return "boot verwijderd";
    }

    @DeleteMapping("/bootverwijderen/{bootId}")
    public String bootVerwijderenPath(@PathVariable long bootId) {
        System.out.println("verwijder path " +bootId);
        vs.bootVerwijderen(bootId);
        return "verwijderen geslaagd path";
    }

    @DeleteMapping("/bootVerwijderenreq")
    public String booterwijderenReq(@RequestParam long bootId) {
        System.out.println("verwijder req" + bootId);
        vs.bootVerwijderen(bootId);
        return "verwijderen geslaagd req";
    }

    @GetMapping("/beschikbareBoten")
    public void beschikbareBoten () {
        vs.beschikbareBoten();
    }

    /*
    @GetMapping("/test")
    public void main () {
        vs.probeersel();
    }
    */

}
