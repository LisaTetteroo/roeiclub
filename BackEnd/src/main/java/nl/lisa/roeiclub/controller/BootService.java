package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional


public class BootService {
    @Autowired
    BootRepository br;

    public void bootToevoegen(Boot boot) {
        System.out.println("in service bootToevoegen");
        br.save(boot);
    }

}
