package nl.lisa.roeiclub.domein;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Lid {
    public Lid () {
    }

    public Lid(String voornaam, String tussenvoegsel, String achternaam) {
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
    }

    public Lid(String id) {
        this.id = Long.parseLong(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private char geslacht;
    private LocalDate geboorteDatum;
    private boolean huidigLid;
    private String straat;
    private int huisnummer;
    private String postcode;
    private String plaats;
    private String email;
    private String telefoonnummer;
    private String telefoonnummerNood;
    private String opleiding;
    private String rekeningnummer;

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public char getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(char geslacht) {
        this.geslacht = geslacht;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public boolean isHuidigLid() {
        return huidigLid;
    }

    public void setHuidigLid(boolean huidigLid) {
        this.huidigLid = huidigLid;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getTelefoonnummerNood() {
        return telefoonnummerNood;
    }

    public void setTelefoonnummerNood(String telefoonnummerNood) {
        this.telefoonnummerNood = telefoonnummerNood;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    @Override
    public String toString() {
        return "Lid{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                '}';
    }
}
