package net.houwing.repository;

import net.houwing.controller.KlantDto;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KlantenRepository {


    private List<Klant> klanten = new ArrayList<>();

    public KlantenRepository() {
        klanten.add(new Klant(1, "Klaasje","Vaak"));
        klanten.add(new Klant(2, "Pieter","Saakstra","22-33-44-567"));
        klanten.add(new Klant(3,"Pieter","Pietersmae","11-55-88-987"));
    }

    public List<Klant> getAlleKlanten() {
        return klanten;
    }

    public void renameKlant(Klant klant) {
        klanten.get(klant.getId()).setVoornaam(klant.getVoornaam());
    }

    public void deleteKlant(Klant klant) {
        klanten.remove(klant);
    }

    public void delKlantById (Klant klant, int id){

        int i = klanten.indexOf(klant);
        klanten.remove(i);
    }

    public void updateKlantById (Klant klant , Klant dtoKlant){
        int i = klanten.indexOf(klant);
        klanten.set(i,dtoKlant);
        //klanten.set(klanten.indexOf(klant), klant);
        //Integer dtoId = klantDto.getId();
        //Integer klantId = klant.getId();
        //int i = klanten.indexOf(dtoId);
        //klanten.set(i,klant);
    }

    public void addKlant (Klant klant){
        //klanten.add(new KlantenModel(3,"Rense","Houwing","123456"));
        // ToDo - Generate an id...
        klanten.add(klant);
    }
}
