package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Palen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional


public class BootService {
    @Autowired
    BootRepository br;

    @Autowired
    PalenRepository pr;

    public void bootToevoegen(Boot b) {
        System.out.println("in service bootToevoegen");
        pr.save(b.getPalen());
        br.save(b);
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

    public void probeersel () {
        System.out.println("bla");
        Boot b = new Boot();
        Palen p = new Palen();
        pr.save(p);
        b.setPalen(p);
        br.save(b);
    }
}
