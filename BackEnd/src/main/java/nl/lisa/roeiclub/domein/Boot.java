package nl.lisa.roeiclub.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String naam;
    private String type;
    private boolean beschikbaar;
    private String gebruikType;
    private int loodsNummer;
    private int palenId;
    private boolean stuurtje;
    private boolean losRoer;
    private boolean losBankje;
    private String aanvullendeInformatie;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBeschikbaar() {
        return beschikbaar;
    }

    public void setBeschikbaar(boolean beschikbaar) {
        this.beschikbaar = beschikbaar;
    }

    public String getGebruikType() {
        return gebruikType;
    }

    public void setGebruikType(String gebruikType) {
        this.gebruikType = gebruikType;
    }

    public int getLoodsNummer() {
        return loodsNummer;
    }

    public void setLoodsNummer(int loodsNummer) {
        this.loodsNummer = loodsNummer;
    }

    public int getPalenId() {
        return palenId;
    }

    public void setPalenId(int palenId) {
        this.palenId = palenId;
    }

    public boolean isStuurtje() {
        return stuurtje;
    }

    public void setStuurtje(boolean stuurtje) {
        this.stuurtje = stuurtje;
    }

    public boolean isLosRoer() {
        return losRoer;
    }

    public void setLosRoer(boolean losRoer) {
        this.losRoer = losRoer;
    }

    public boolean isLosBankje() {
        return losBankje;
    }

    public void setLosBankje(boolean losBankje) {
        this.losBankje = losBankje;
    }

    public String getAanvullendeInformatie() {
        return aanvullendeInformatie;
    }

    public void setAanvullendeInformatie(String aanvullendeInformatie) {
        this.aanvullendeInformatie = aanvullendeInformatie;
    }
}