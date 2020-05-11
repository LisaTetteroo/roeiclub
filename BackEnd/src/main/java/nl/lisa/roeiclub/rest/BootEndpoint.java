package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.VlootService;
import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Lid;
import nl.lisa.roeiclub.domein.Palen;
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
        return vs.bootVerwijderen(boot.getId());
    }

    @DeleteMapping("/bootverwijderen/{bootId}")
    public String bootVerwijderenPath(@PathVariable long bootId) {
        System.out.println("verwijder path " +bootId);
        return vs.bootVerwijderen(bootId);
    }

    @DeleteMapping("/bootVerwijderenreq")
    public String booterwijderenReq(@RequestParam long bootId) {
        System.out.println("verwijder req" + bootId);
        return vs.bootVerwijderen(bootId);
    }

    @GetMapping("/beschikbareBoten")
    public Iterable<Boot> beschikbareBoten () {
        return vs.beschikbareBoten();
    }

    /*
    @GetMapping("/test")
    public void main () {
        vs.probeersel();
    }
    */

}
