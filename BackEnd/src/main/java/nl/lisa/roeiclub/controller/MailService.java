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

        String mailTitel = "Bevestiging reservering";
        String mailText = "Beste " + a.getLid().getVoornaam() + ",\n" +
                            "Voor " + r.getDatum() + " heb je een  reservering gemaakt van de " + b.getNaam() + ".\n" +
                            "de reservering is van " + r.getStartTijd() + "tot " + r.getEindTijd() + ".\n" +
                            "De boot is te vinden in loods " + b.getLoodsNummer() + ".\n" +
                            "Je mag voor deze bootgebruik maken van palen met het nummer " + r.getBoot().getPalen().getId() + ", te vinden in rek " + r.getBoot().getPalen().getLocatie() + ".\n" +
                            "We willen je verzoeken de reservering te annuleren als de training geen doorgang vindt. \n" +
                            "geniet van de training, \n" +
                            "Cees, mede namens het ht Bestuur";


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(mailTitel);
        mailMessage.setTo(emailadres);
        mailMessage.setText(mailText);

        ac.getJavaMailSender().send(mailMessage);
    }

    public void sendAnnuleringMail(Reservering r) throws Exception{
        Account a = r.getAccount();
        Boot b = r.getBoot();
        String emailadres = a.getLid().getEmail();

        String mailTitel = "Annulering van een door u gemaakt reservering";
        String mailText = "Beste " + a.getLid().getVoornaam() + ",\n" +
                "Middels deze melding laten wij weten dat reservering op  " + r.getDatum() + " van de " + b.getNaam() + " is geannuleerd vanuit jouw account of door de Bootsman.\n" +
                "met vriendelijke groet, \n" +
                "Cees, mede namens het ht Bestuur";


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(mailTitel);
        mailMessage.setTo(emailadres);
        mailMessage.setText(mailText);

        ac.getJavaMailSender().send(mailMessage);
    }

    /*public void sendAnnuleringBootsmanMail(Reservering r) throws Exception{
        Account a = r.getAccount();
        Boot b = r.getBoot();
        String emailadres = a.getLid().getEmail();

        String mailTitel = "Annulering van een door u gemaakt reservering";
        String mailText = "Beste " + a.getLid().getVoornaam() + ",\n" +
                "Middels deze melding laten wij weten dat reservering op  " + r.getDatum() + " van de " + b.getNaam() + " is geannuleerd door mij.\n" +
                "Dit kan zijn vanwege onderhoud, voor wedstrijden of vanwege andere redenen waardoor de boot niet beschikbaar zal zijn die dag.\n" +
                "met vriendelijke groet, \n" +
                "Cees, mede namens het ht Bestuur";


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(mailTitel);
        mailMessage.setTo(emailadres);
        mailMessage.setText(mailText);

        ac.getJavaMailSender().send(mailMessage);
    }*/
}
