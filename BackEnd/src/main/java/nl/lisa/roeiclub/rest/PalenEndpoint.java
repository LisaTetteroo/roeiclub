package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.VlootService;
import nl.lisa.roeiclub.domein.Palen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PalenEndpoint {
    @Autowired
    VlootService vs;

    @PostMapping("/palenToevoegen")
    public String palenToevoegen(@RequestBody Palen palen) {
        return vs.palenToevoegen(palen);
    }

    @GetMapping("/palenInzien")
    public  Iterable<Palen> palenInzien() {
        System.out.println("in palenInzien in palenEndpoint");
        return vs.palenInzien( );
    }

    @DeleteMapping("/palenVerwijderen/{palenId}")
    public String palenVerwijderen (@PathVariable long palenId){
        System.out.println(" palen verwijderen met path " + palenId);

        return vs.palenVerwijderen(palenId);
    }

}
