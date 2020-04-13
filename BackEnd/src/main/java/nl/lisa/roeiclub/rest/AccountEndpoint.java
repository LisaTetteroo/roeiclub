package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.LidService;
import nl.lisa.roeiclub.controller.VlootService;
import nl.lisa.roeiclub.domein.Lid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
