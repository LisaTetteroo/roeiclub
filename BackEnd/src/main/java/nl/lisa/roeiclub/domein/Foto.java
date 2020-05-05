package nl.lisa.roeiclub.domein;

import javax.persistence.*;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "LONGBLOB")
    private String foto;

    @OneToOne
    Lid lid;

    public long getId() {
        return id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Lid getLid() {
        return lid;
    }

    public void setLid(Lid lid) {
        this.lid = lid;
    }
}
