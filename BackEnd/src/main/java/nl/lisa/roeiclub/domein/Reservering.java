package nl.lisa.roeiclub.domein;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reservering implements Comparable<Reservering>{
    public Reservering () {
    }

    public Reservering(Boot boot, Account account, LocalDate datum, LocalTime startTijd, LocalTime eindTijd) {
        this.boot = boot;
        this.account = account;
        this.datum = datum;
        this.startTijd = startTijd;
        this.eindTijd = eindTijd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate datum;
    private LocalTime startTijd;
    private LocalTime eindTijd;

    @ManyToOne
    private Boot boot;

    @ManyToOne
    private Account account;

    public long getId() {
        return id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getStartTijd() {
        return startTijd;
    }

    public void setStartTijd(LocalTime startTijd) {
        this.startTijd = startTijd;
    }

    public LocalTime getEindTijd() {
        return eindTijd;
    }

    public void setEindTijd(LocalTime eindTijd) {
        this.eindTijd = eindTijd;
    }

    public Boot getBoot() {
        return boot;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public int compareTo(Reservering o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Reservering{" +
                "datum=" + datum +
                ", boot=" + boot +
                '}';
    }
}
