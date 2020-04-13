package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.LidService;
import nl.lisa.roeiclub.domein.Lid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
public class LidEndpoint {
    @Autowired
    LidService ls;

    @PostMapping("/lidToevoegenreq")
    public String lidToevoegen (@RequestParam String vn, @RequestParam String tv, @RequestParam String an) {
        System.out.println("in LidEndpoint in LidToevoegen" + vn + " " + tv + " " + an);
        String message = ls.lidToevoegen(vn, tv, an);
        return message;
    }
}
