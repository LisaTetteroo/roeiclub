package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Palen;
import nl.lisa.roeiclub.domein.Reservering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    public void reserveringMaken(long bootId, long accountId, LocalDate datumReservering) {
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
            } else {
                message = "boot werd niet gevonden";
                System.out.println("geen boot gevonden");
                return;
            }
        }

        for (Account account:accounts) {
            if (account.getId() == accountId) {
                System.out.println("account gevonden met id: " + account.getId());
                a = account;
            } else {
                message = "account werd niet gevonden";
                System.out.println("geen account gevonden");
                return;
            }
        }


        // datum controle
        boolean datumBezet = false;
        System.out.println(datumReservering);
        List<Reservering> reserveringPerBoot = rr.findByBoot(b);
        System.out.println(reserveringPerBoot);
        for (Reservering reservering : reserveringPerBoot) {
            System.out.println("in reserveringPerBoot enhanced for loop");
            if (reservering.getDatum().equals(datumReservering)) {
                System.out.println("datum is gelijk");
                datumBezet = true;
                break;
            } else {
                continue;
            }
        }
        if (datumBezet == false) {
            Reservering r = new Reservering(b , a , datumReservering);
            rr.save(r);
            System.out.println("reservering op datum gelukt");
        } else {
            message = "boot is niet beschikbaar op die datum";
            System.out.println(message);
        }

       // Reservering r = new Reservering(b ,a);
       // rr.save(r);
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
