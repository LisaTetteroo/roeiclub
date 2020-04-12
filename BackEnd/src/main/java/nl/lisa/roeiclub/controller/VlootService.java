package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Palen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional


public class VlootService {
    @Autowired
    BootRepository br;

    @Autowired
    PalenRepository pr;

    public String bootToevoegen(Boot b) {
        System.out.println("in service bootToevoegen");
        Palen p = b.getPalen();
        Long paalId = p.getId();
        Optional<Palen> palenoverzichtOptional = pr.findById(paalId);
        if (palenoverzichtOptional.isPresent()) {
            pr.save(p);
            br.save(b);
            return b.getNaam() + " is succesvol opgeslagen.";
        } else {
            return "Er is voor een nog niet bestaande paal gekozen, indien nog onbekend kies 1, of kies een paal die wel bestaat.";
        }
    }

    public Iterable<Boot> botenInzien() {
        Iterable<Boot> botenOverzicht = br.findAll();
        for (Boot boot : botenOverzicht) {
            System.out.println("in botenInzien in BootService: " + boot.getPalen());
        }
        return botenOverzicht;
    }

    public void bootVerwijderen(Long id) {
        System.out.println("in bootVerwijderen in BootService");
        br.deleteById(id);
    }

    public void beschikbareBoten () {
        Iterable<Boot> botenOverzicht = br.findByBeschikbaarTrue();;
        for (Boot boot : botenOverzicht) {
            System.out.println(boot.getNaam() + " is beschikbaar");
        }
    }

    public String palenToevoegen(Palen p) {
        System.out.println("in service palen toevoegen");
        pr.save(p);
        return "palen toevoegen succesvol";
    }

    public Iterable<Palen> palenInzien() {
        Iterable<Palen> palenOverzicht = pr.findAll();
        return palenOverzicht;
    }

    public void palenVerwijderen(Long id) {
        System.out.println("in palenVerwijderen in VlootService");
        pr.deleteById(id);
    }

    /*(
    public void probeersel () {
        System.out.println("bla");
        Boot b = new Boot();
        Palen p = new Palen();
        pr.save(p);
        b.setPalen(p);
        br.save(b);
    }
    */
}
