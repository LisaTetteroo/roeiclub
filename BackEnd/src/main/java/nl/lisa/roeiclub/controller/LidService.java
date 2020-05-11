package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Account;
import nl.lisa.roeiclub.domein.Foto;
import nl.lisa.roeiclub.domein.Lid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LidService {
    @Autowired
    LidRepository lr;

    @Autowired
    AccountRepository ar;

    @Autowired
    FotoRepository fr;

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
        String message = null;
        String gebruikersnaam = account.getGebruikersnaam();
        boolean gebruikersnaamBezet = false;
        boolean lidHeeftAlAccount = false;

        Optional<Lid> ledenoverzichtOptional = lr.findById(lidId);
        List<Account> gebruikersnamenAccounts = ar.findByGebruikersnaam(gebruikersnaam);
        Optional<Account> accountOptional = ar.findByLid(lid);

        for (Account a : gebruikersnamenAccounts) {
            if ((a.getGebruikersnaam()).equals(account.getGebruikersnaam())) {
                gebruikersnaamBezet = true;
                message = "Gebruikersnaam is bezet, kies andere gebruikersnaam";
                break;
            }
        }

        if (accountOptional.isPresent()){
            lidHeeftAlAccount = true;
            message = "Er is reeds een account geregistreerd bij dit lidnummer";
        }

        if (ledenoverzichtOptional.isPresent()) {
            if ((lidHeeftAlAccount == false) && (gebruikersnaamBezet == false)) {

                ar.save(account);
                message = "account is succesvol aangemaakt";
            }
        } else {
            message = "het ingevoerde lidnummer bestaat niet. Probeer opnieuw";
        }

        return message;
    }

    public Account accountInzienBijGebruikersnaam(String gebruikersnaam) {
        System.out.println("in lidservic gebruikersnaam: " + gebruikersnaam);
        Account accountGebruikersnaam = null;
        List<Account> accountMetGbruikersnaam = ar.findByGebruikersnaam(gebruikersnaam);
        System.out.println(accountMetGbruikersnaam);
        if (accountMetGbruikersnaam.size() == 1) {
            accountGebruikersnaam = accountMetGbruikersnaam.get(0);
            System.out.println("gevonden: " + accountGebruikersnaam);
        }
        return accountGebruikersnaam;
    }

    public void fotoToevoegen(MultipartFile file, Long id) throws IOException {
        System.out.println("in lidservice fotoToevoegen");
        Foto foto = new Foto();
        foto.setFoto(Base64.getEncoder().encodeToString(file.getBytes()));
        fr.save(foto);
    }
}
