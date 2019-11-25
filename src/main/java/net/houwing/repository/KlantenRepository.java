package net.houwing.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KlantenRepository {


    private List<KlantModel> klanten = new ArrayList<>();

    public KlantenRepository() {
        klanten.add(new KlantModel(1, "Klaasje","Vaak"));
        klanten.add(new KlantModel(2, "Pieter","Saakstra","22-33-44-567"));
    }

    public List<KlantModel> getAlleKlantenRepository() {
        return klanten;
    }

    public KlantModel getKlantById(Integer id) {
        return klanten.get(id);
    }

    public void renameKlant(KlantModel klantModel) {
        klanten.get(klantModel.getId()).setNaam(klantModel.getNaam());
    }

    public void deleteKlant(KlantModel klantModel) {
        klanten.remove(klantModel.getId());
    }

    public void addKlant (KlantModel klantModel){
        //klanten.add(new KlantenModel(3,"Rense","Houwing","123456"));
        // ToDo - Generate an id...
        klanten.add(klantModel);
    }

//    public void addKlant (String naam , String achternaam , String banknummer){
//        //klanten.add(new KlantenModel(3,"Rense","Houwing","123456"));
//        // ToDo - Generate an id...
//        klanten.add(new KlantenModel(6, naam, achternaam, banknummer));
//    }


}
