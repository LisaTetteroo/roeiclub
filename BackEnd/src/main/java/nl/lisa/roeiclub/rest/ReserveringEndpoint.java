package nl.lisa.roeiclub.rest;


import nl.lisa.roeiclub.controller.VlootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController

public class ReserveringEndpoint {
    @Autowired
    VlootService vs;

    @PostMapping("/reserveringMakenreq")
    public void reserveringMaken(@RequestParam String bootIdParam, @RequestParam String accountIdParam, @RequestParam String datumReserveringParam) {
        System.out.println("In endpoint reserveringmaken");
        long bootId = Long.parseLong(bootIdParam);
        long accountId = Long.parseLong(accountIdParam);
        LocalDate datumReservering = LocalDate.parse(datumReserveringParam);
        vs.reserveringMaken(bootId, accountId, datumReservering);
    }
    //noteToSelf: local date = YYYY/MM/DD

}
