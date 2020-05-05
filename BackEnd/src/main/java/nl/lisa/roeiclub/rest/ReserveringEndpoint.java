package nl.lisa.roeiclub.rest;


import nl.lisa.roeiclub.controller.VlootService;
import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Reservering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@RestController

public class ReserveringEndpoint {
    @Autowired
    VlootService vs;

    @PostMapping("/reserveringMakenreq")
    public void reserveringMaken(@RequestParam String bootIdParam, @RequestParam String accountIdParam, @RequestParam String datumReserveringParam, @RequestParam String startTijdParam, @RequestParam String eindTijdParam) {
        System.out.println("In endpoint reserveringmaken");
        long bootId = Long.parseLong(bootIdParam);
        long accountId = Long.parseLong(accountIdParam);
        LocalDate datumReservering = LocalDate.parse(datumReserveringParam);
        DateTimeFormatter tijdFormatter = DateTimeFormatter.ofPattern("HH':'mm");
        LocalTime startTijd = LocalTime.parse(startTijdParam, tijdFormatter);
        LocalTime eindTijd = LocalTime.parse(eindTijdParam, tijdFormatter);
        //LocalTime eindTijd = LocalTime.of(14,00);
        vs.reserveringMaken(bootId, accountId, datumReservering, startTijd, eindTijd);
    }

    @GetMapping("/reserveringInzienreq")
    public Iterable<Reservering> reserveringInzien(@RequestParam String accountIdString) {
        System.out.println("in reservering inzien endpoint");
        Long accountIdLong = Long.parseLong(accountIdString);
        return vs.reserveringInzien(accountIdLong);
    }

    @DeleteMapping("/reserveringAnnuleren")
    public String bootVerwijderen (@RequestBody Reservering reservering) {
        System.out.println("in reserveringAnnuleren in reserveringEndpoint");
        vs.reserveringAnnuleren(reservering.getId());
        return "reservering geannuleerd";
    }


}
