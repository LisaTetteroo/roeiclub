package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional


public class VlootService {
    @Autowired
    BootRepository br;

    @Autowired
    PalenRepository pr;

    @Autowired
    AccountRepository ar;

    @Autowired
    ReserveringRepository rr;

    @Autowired
    LidRepository lr;

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

    public void reserveringMaken(long bootId, long accountId, LocalDate datumReservering, LocalTime startTijd, LocalTime eindTijd) {
        System.out.println("in vlootservice in reserveringmaken");
        Boot b = null;
        Account a = null;
        String message = null;
        Iterable<Account> accounts = ar.findAll();
        Iterable<Boot> boten = br.findAll();
        for (Boot boot:boten) {
            if (boot.getId() == bootId) {
                System.out.println("boot gevonden met id: " + boot.getId());
                b = boot;
                break;
            }
        }

        for (Account account:accounts) {
            if (account.getId() == accountId) {
                System.out.println("account gevonden met id: " + account.getId());
                a = account;
                break;
            }
        }

        // datum controle
        boolean bootBezet = false;
        System.out.println(datumReservering);
        List<Reservering> bootOpDatum = rr.findByBootAndDatum(b, datumReservering);
        if (bootOpDatum.size() != 0) {
            //System.out.println("deze boot is al eens op deze datum gereserveerd");
            // tijdscontrole:
            for(Reservering r:bootOpDatum) {
                if (startTijd.isBefore(r.getEindTijd()) && eindTijd.isAfter(r.getStartTijd())) {
                    bootBezet = true;
                    message = "boot is bezet";
                    break;
                }
            }
        }

        if (bootBezet == false) {
            Reservering r = new Reservering(b , a , datumReservering, startTijd, eindTijd);
            rr.save(r);
            message = "reservering op datum gelukt";
        }
        System.out.println(message);
    }

    public void dummyDB(Lid lid, Account account, Palen palen, Boot boot) {
        lr.save(lid);
        ar.save(account);
        pr.save(palen);
        br.save(boot);
    }

    /*
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
