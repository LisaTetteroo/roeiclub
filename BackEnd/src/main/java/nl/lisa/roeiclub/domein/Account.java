package nl.lisa.roeiclub.domein;

import javax.persistence.*;

@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"gebruikersnaam"})})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String gebruikersnaam;
    private String wachtwoord;

    @OneToOne
    private Lid lid;

    public long getId() {
        return id;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Lid getLid() {
        return lid;
    }

    public void setLid(Lid lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", gebruikersnaam='" + gebruikersnaam + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", lid=" + lid +
                '}';
    }
}
