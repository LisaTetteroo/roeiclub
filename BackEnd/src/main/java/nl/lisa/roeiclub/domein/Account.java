package nl.lisa.roeiclub.domein;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;

@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"gebruikersnaam"})})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String gebruikersnaam;
    private String wachtwoordHash;
    private String rol;

    //private static PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @OneToOne
    private Lid lid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    /*public String getWachtwoord() {
        return wachtwoordHash;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoordHash = wachtwoord;
    }*/

    @JsonIgnore
    public String getWachtwoordHash() {
        return wachtwoordHash;
    }
    @JsonProperty
    public void setWachtwoordHash(String wachtwoordHash) {
        this.wachtwoordHash = wachtwoordHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
