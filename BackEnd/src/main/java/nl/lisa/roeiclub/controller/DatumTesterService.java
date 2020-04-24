package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.DatumTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class DatumTesterService {
    @Autowired
    DatumTesterRepository dtr;

    public void datumAanmaken (DatumTester datum) {
        System.out.println("in service");
        dtr.save(datum);
    }

    public void datumOpvragen () {
        Iterable<DatumTester> datums = dtr.findAll();
        System.out.println(datums);
    }
}
