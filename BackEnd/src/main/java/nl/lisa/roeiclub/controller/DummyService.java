package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Lid;
import nl.lisa.roeiclub.domein.Palen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class DummyService {
    @Autowired
    BootRepository br;

    @Autowired
    PalenRepository pr;

    @Autowired
    AccountRepository ar;

    @Autowired
    LidRepository lr;

    public void dummyDB(Lid lid, Account account, Palen palen, Boot boot) {
        lr.save(lid);
        ar.save(account);
        pr.save(palen);
        br.save(boot);
    }

    public void dummyLid(Lid lid) {
        lr.save(lid);
    }

    public void dummyPaal(Palen palen) {
        pr.save(palen);
    }
}
