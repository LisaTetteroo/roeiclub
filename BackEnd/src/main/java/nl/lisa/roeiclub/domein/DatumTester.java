package nl.lisa.roeiclub.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class DatumTester {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate datumTest;

    public LocalDate getDatumTest() {
        return datumTest;
    }

    public void setDatumTest(LocalDate datumTest) {
        this.datumTest = datumTest;
    }

    @Override
    public String toString() {
        return "DatumTester{" +
                "id=" + id +
                ", datumTest=" + datumTest +
                '}';
    }
}
