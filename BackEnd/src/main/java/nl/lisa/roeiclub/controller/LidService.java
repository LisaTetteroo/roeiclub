package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Lid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LidService {
    @Autowired
    LidRepository lr;

    @Autowired
    AccountRepository ar;

    public String lidToevoegen (String vn, String tv, String an) {
        System.out.println("in lidservice, lidtoevoegen");
        Lid lid = new Lid(vn, tv, an);
        lr.save(lid);
        return " ";
    }

    public String accountToevoegen (Account account) {
        System.out.println("in lidservice accountToevoegen");
        Lid lid = account.getLid();
        Long lidId = lid.getId();
        Optional<Lid> ledenoverzichtOptional = lr.findById(lidId);
        if (ledenoverzichtOptional.isPresent()) {
            ar.save(account);
            return "account is succesvol aangemaakt";
        } else {
            return "het ingevoerde lidnummer bestaat niet. Probeer opnieuw";
        }
    }

}
