package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.DatumTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DatumTesterEndpoint {
    @Autowired
    DatumTesterService dts;

    @PostMapping("/datumTestAanmaken")
    public void datumTestAanmaken () {
        System.out.println("in datumtesterendpoint datumtestaanmaken");
        DatumTester test = new DatumTester();
        test.setDatumTest(LocalDate.parse("2020-05-28"));
        System.out.println(test.getDatumTest());
        dts.datumAanmaken(test);
    }

    @GetMapping("/datumTestOpvragen")
    public void datumTestOpvragen () {
        dts.datumOpvragen();
    }


}
