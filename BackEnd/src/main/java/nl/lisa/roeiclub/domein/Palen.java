package nl.lisa.roeiclub.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Palen {
    public Palen() {
    }



    public Palen(String id) {
        this.id = Long.parseLong(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String soort;
    private int locatie;
    private int aantal;
    private String toekenning;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public int getLocatie() {
        return locatie;
    }

    public void setLocatie(int locatie) {
        this.locatie = locatie;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public String getToekenning() {
        return toekenning;
    }

    public void setToekenning(String toekenning) {
        this.toekenning = toekenning;
    }

    @Override
    public String toString() {
        return "Palen{" +
                "id=" + id +
                '}';
    }
}
