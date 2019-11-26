package net.houwing.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class KlantenRepository {


    private List<Klant> klanten = new ArrayList<>();

    public KlantenRepository() {
        klanten.add(new Klant(1, "Klaasje", "Vaak"));
        klanten.add(new Klant(2, "Henk", "Saakstra", "22-33-44-567"));
        klanten.add(new Klant(5, "Pieter", "Pietersma", "11-55-88-987"));
    }

    public List<Klant> getAlleKlanten() {
        return klanten;
    }

    public void delKlantById(Klant klant, int id) {
        int klantIndex = klanten.indexOf(klant);
        klanten.remove(klantIndex);
    }

    public void updateKlantById(Klant klant, Klant dtoKlant) {
        dtoKlant.setId(klant.getId());
        int klantIndex = klanten.indexOf(klant);
        klanten.set(klantIndex, dtoKlant);
    }

    public void addKlant(Klant klant) {
        Klant klantMaxId = Collections.max(klanten, Comparator.comparing(Klant::getId));
        Integer newId = klantMaxId.getId() + 1;
        klant.setId(newId);
        klanten.add(klant);
    }
}
