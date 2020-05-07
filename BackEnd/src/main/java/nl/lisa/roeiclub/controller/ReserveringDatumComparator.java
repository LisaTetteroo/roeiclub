package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Reservering;

import java.util.Comparator;

public class ReserveringDatumComparator implements Comparator<Reservering> {
    public int compare(Reservering r1, Reservering r2) {
        return r1.getDatum().compareTo(r2.getDatum());
    }
}
