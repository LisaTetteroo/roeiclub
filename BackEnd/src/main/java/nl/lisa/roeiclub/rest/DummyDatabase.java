package nl.lisa.roeiclub.rest;

import nl.lisa.roeiclub.controller.DummyService;
import nl.lisa.roeiclub.domein.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;


@RestController
public class DummyDatabase {
    @Autowired
    DummyService ds;

    @PostMapping("/dummyDB")
    public void dummyDB () {
        Palen paalOnbekend = new Palen();
        paalOnbekend.setLocatie(0);
        paalOnbekend.setSoort("paal onbekend/nvt");
        paalOnbekend.setToekenning("nvt");
        paalOnbekend.setAantal(0);
        ds.dummyPaal(paalOnbekend);

        Lid lid = new Lid();
        lid.setVoornaam("Jane");
        lid.setAchternaam("Doe");
        lid.setEmail("vlootsysteem@gmail.com");
        Account account = new Account();
        account.setLid(lid);
        account.setGebruikersnaam("test");
        account.setWachtwoordHash("test");
        Palen palen = new Palen();
        palen.setSoort("Boord bigblade");
        palen.setToekenning("EJD");
        palen.setAantal(8);
        palen.setLocatie(4);
        Boot boot = new Boot();
        boot.setNaam("Dwars");
        boot.setPalen(palen);
        boot.setType("8+");
        boot.setGebruikType("Wedstro");
        boot.setLoodsNummer(3);
        boot.setAanvullendeInformatie("Toegewezen aan EJD. De dwars is in het echt een B4+, en favo boot van dandalunda");
        ds.dummyDB(lid, account, palen, boot);

        Lid lid2 = new Lid();
        lid2.setVoornaam("Victoria");
        lid2.setAchternaam("Regia");
        lid2.setEmail("vlootsysteem@gmail.com");
        Account account2 = new Account();
        account2.setLid(lid2);
        account2.setGebruikersnaam("test2");
        account2.setWachtwoordHash("test2");
        Palen palen2 = new Palen();
        palen2.setSoort("scull smoothie");
        palen2.setAantal(2);
        palen2.setToekenning("Wallie");
        palen2.setLocatie(6);
        Boot boot2 = new Boot();
        boot2.setNaam("Aquarius");
        boot2.setPalen(palen2);
        boot2.setType("1x");
        boot2.setAanvullendeInformatie("Toegewezen aan Wallie. De orginele aquarius is een C2x.");
        boot2.setLoodsNummer(2);
        boot2.setBeschikbaar(true);
        boot2.setGebruikType("wedstro");
        ds.dummyDB(lid2, account2, palen2, boot2);

        Lid lid3 = new Lid();
        lid3.setVoornaam("John");
        lid3.setAchternaam("Doe");
        lid3.setEmail("vlootsysteem@gmail.com");
        Account account3 = new Account();
        account3.setLid(lid3);
        account3.setGebruikersnaam("test3");
        account3.setWachtwoordHash("test3");
        Palen palen3 = new Palen();
        palen3.setSoort("boord tulp");
        palen3.setAantal(4);
        palen3.setToekenning("Compo");
        palen3.setLocatie(14);
        Boot boot3 = new Boot();
        boot3.setNaam("Knorretje");
        boot3.setPalen(palen3);
        boot3.setBeschikbaar(true);
        boot3.setGebruikType("compo");
        boot3.setType("C4+");
        boot3.setLoodsNummer(1);
        boot3.setAanvullendeInformatie("Bij aanschaf biggetjes roze, nu asopos paars");
        ds.dummyDB(lid3, account3, palen3, boot3);

        Lid lid4 = new Lid();
        lid4.setVoornaam("Lisa");
        lid4.setAchternaam("Tetteroo");
        ds.dummyLid(lid4);

        Reservering r1 = new Reservering();
        r1.setBoot(boot);
        r1.setAccount(account2);
        r1.setDatum(LocalDate.parse("2020-05-12"));
        r1.setStartTijd(LocalTime.parse("10:00"));
        r1.setEindTijd(LocalTime.parse("12:00"));
        ds.dummyReservering(r1);

        Reservering r3 = new Reservering();
        r3.setBoot(boot2);
        r3.setAccount(account2);
        r3.setDatum(LocalDate.parse("2020-05-12"));
        r3.setStartTijd(LocalTime.parse("10:00"));
        r3.setEindTijd(LocalTime.parse("12:00"));
        ds.dummyReservering(r3);

        Reservering r2 = new Reservering();
        r2.setBoot(boot2);
        r2.setAccount(account);
        r2.setDatum(LocalDate.parse("2020-05-12"));
        r2.setStartTijd(LocalTime.parse("18:00"));
        r2.setEindTijd(LocalTime.parse("20:00"));
        ds.dummyReservering(r2);

        Reservering r4 = new Reservering();
        r4.setBoot(boot);
        r4.setAccount(account2);
        r4.setDatum(LocalDate.parse("2020-05-13"));
        r4.setStartTijd(LocalTime.parse("10:00"));
        r4.setEindTijd(LocalTime.parse("12:00"));
        ds.dummyReservering(r4);

        Reservering r5 = new Reservering();
        r5.setBoot(boot3);
        r5.setAccount(account3);
        r5.setDatum(LocalDate.parse("2020-05-12"));
        r5.setStartTijd(LocalTime.parse("12:00"));
        r5.setEindTijd(LocalTime.parse("14:00"));
        ds.dummyReservering(r5);

        Admin bootsman = new Admin();
        bootsman.setGebruikersnaam("admin");
        bootsman.setWachtwoordHash("admin");
        ds.bootsmanAccount(bootsman);

        /*Account fouteGegevens = new Account();
        account.setGebruikersnaam("fout");*/
    }
}
