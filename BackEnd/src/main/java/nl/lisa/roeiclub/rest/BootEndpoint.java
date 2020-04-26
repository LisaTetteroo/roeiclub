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

    @PostMapping("/dummyDB")
    public void dummyDB () {
        Lid lid = new Lid();
        lid.setVoornaam("Jane");
        lid.setAchternaam("Doe");
        Account account = new Account();
        account.setLid(lid);
        account.setGebruikersnaam("test");
        Palen palen = new Palen();
        palen.setSoort("Boord bigblade");
        Boot boot = new Boot();
        boot.setNaam("Dwars");
        boot.setPalen(palen);
        vs.dummyDB(lid, account, palen, boot);
        Lid lid2 = new Lid();
        lid2.setVoornaam("Victoria");
        lid2.setAchternaam("Regia");
        Account account2 = new Account();
        account2.setLid(lid2);
        account2.setGebruikersnaam("test2");
        Palen palen2 = new Palen();
        palen2.setSoort("scull smoothie");
        palen2.setAantal(4);
        Boot boot2 = new Boot();
        boot2.setNaam("aquarius");
        boot2.setPalen(palen2);
        vs.dummyDB(lid2, account2, palen2, boot2);
        Lid lid3 = new Lid();
        lid3.setVoornaam("john");
        lid3.setAchternaam("doe");
        Account account3 = new Account();
        account3.setLid(lid3);
        account3.setGebruikersnaam("test3");
        Palen palen3 = new Palen();
        palen3.setSoort("boord tulp");
        palen3.setAantal(4);
        Boot boot3 = new Boot();
        boot3.setNaam("knorretje");
        boot3.setPalen(palen3);
        vs.dummyDB(lid3, account3, palen3, boot3);
    }

    /*
    @GetMapping("/test")
    public void main () {
        vs.probeersel();
    }
    */

}
