package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.LidService;
import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminEndpoint {
    @Autowired
    LidService ls;


    @GetMapping("/inloggenBootsman/{gebruikersnaam}-{wachtwoord}")
    public Admin Inloggen(@PathVariable String gebruikersnaam, @PathVariable String wachtwoord) {
        System.out.println("in admin endpoint gebruikersnaam: " + gebruikersnaam);
        System.out.println("wachtwoord: " + wachtwoord);
        Admin account = ls.inloggenBootsman(gebruikersnaam, wachtwoord);
        System.out.println(account);
        return account;
    }


}
