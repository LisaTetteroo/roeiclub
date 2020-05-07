package nl.lisa.roeiclub.controller;

import nl.lisa.roeiclub.domein.Reservering;

import java.util.Comparator;

public class ReserveringBootNaamComparator implements Comparator<Reservering> {
    public int compare(Reservering r1, Reservering r2) {
        return r1.getBoot().getNaam().compareToIgnoreCase(r2.getBoot().getNaam());
    }
}
