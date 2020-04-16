package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.LidService;
import nl.lisa.roeiclub.controller.VlootService;
import nl.lisa.roeiclub.domein.Lid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import nl.lisa.roeiclub.domein.Account;

@RestController
public class AccountEndpoint {
    @Autowired
    LidService ls;

    @PostMapping("/accountToevoegen")
    public String accountToevoegen (@RequestBody Account account) {
        System.out.println("in LidEndpoint in LidToevoegen");
        String message = ls.accountToevoegen(account);
        return message;
    }

    @GetMapping("/accountBijGebruikersnaamOpvragen/{gebruikersnaam}")
    public Account lidIdBijGebruikersnaamOpvragen(@PathVariable String gebruikersnaam) {
        //String gebruikersnaam = gebruikersnaam;
        System.out.println("in account endpoint gebruikersnaam: " + gebruikersnaam);
        Account accountGebruikersnaam = ls.accountInzienBijGebruikersnaam(gebruikersnaam);
        System.out.println(accountGebruikersnaam);
        return accountGebruikersnaam;
    }
}
