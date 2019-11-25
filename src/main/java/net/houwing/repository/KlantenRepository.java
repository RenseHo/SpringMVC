package net.houwing.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KlantenRepository {


    private List<KlantenModel> klanten = new ArrayList<>();

    public KlantenRepository() {
        klanten.add(new KlantenModel(1, "Klaasje","Vaak"));
        klanten.add(new KlantenModel(2, "Pieter","Saakstra","22-33-44-567"));
    }

    public List<KlantenModel> getAlleKlantenRepository() {
        return klanten;
    }

    public KlantenModel getKlantById(Integer id) {
        return klanten.get(id);
    }

    public void renameKlant(KlantenModel klantenModel) {
        klanten.get(klantenModel.getId()).setNaam(klantenModel.getNaam());
    }

    public void deleteKlant(KlantenModel klantenModel) {
        klanten.remove(klantenModel.getId());
    }

    public void addKlant (KlantenModel klantenModel){
        //klanten.add(new KlantenModel(3,"Rense","Houwing","123456"));
        // ToDo - Generate an id...
        klanten.add(klantenModel);
    }

//    public void addKlant (String naam , String achternaam , String banknummer){
//        //klanten.add(new KlantenModel(3,"Rense","Houwing","123456"));
//        // ToDo - Generate an id...
//        klanten.add(new KlantenModel(6, naam, achternaam, banknummer));
//    }


}
