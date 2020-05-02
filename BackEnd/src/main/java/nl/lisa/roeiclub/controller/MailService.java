package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.config.AppConfig;
import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Boot;
import nl.lisa.roeiclub.domein.Reservering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MailService {
    @Autowired
    AppConfig ac;

    public void sendReserveringMail(Reservering r) throws Exception{
        Account a = r.getAccount();
        Boot b = r.getBoot();
        String emailadres = a.getLid().getEmail();

        String mailTitel = "Bevestiging reservering boot voor " + r.getDatum();
        String mailText = "Beste " + a.getLid().getVoornaam() + ",\n" +
                            "Voor " + r.getDatum() + " heeft u reservering gemaakt van " + b.getNaam() + "." +
                            "U kunt de boot vanaf " + r.getStartTijd() + " afhalen op de loods bij loodsnummer " + b.getLoodsNummer() + ".";


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(mailTitel);
        mailMessage.setTo(emailadres);
        mailMessage.setText(mailText);

        ac.getJavaMailSender().send(mailMessage);
    }
}
