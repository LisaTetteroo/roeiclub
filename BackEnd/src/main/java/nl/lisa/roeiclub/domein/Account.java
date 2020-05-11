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

    //private static PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

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

    public Lid getLid() {
        return lid;
    }

    public void setLid(Lid lid) {
        this.lid = lid;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    /*@JsonIgnore
    public String getWachtwoordHash() {
        return wachtwoordHash;
    }
    @JsonProperty
    public void setWachtwoordHash(String wachtwoordHash) {
        this.wachtwoordHash = passwordEncoder.encode(wachtwoordHash);
    }*/

}
