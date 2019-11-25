package net.houwing.repository;

import net.houwing.controller.KlantDto;

public class KlantenModel {

    private Integer id;
    private String naam;
    private String achternaam;
    private String banknummer;

    public KlantenModel() {
    }

    KlantenModel(Integer id, String naam, String achternaam) {
        this.id = id;
        this.naam = naam;
        this.achternaam = achternaam;
    }

    KlantenModel(Integer id, String naam, String achternaam, String banknummer) {
        this.id = id;
        this.naam = naam;
        this.achternaam = achternaam;
        this.banknummer = banknummer;
    }

    public KlantenModel(KlantDto klantDto) {
        this.id = klantDto.getId();
        this.naam = klantDto.getNaam();
        this.achternaam = klantDto.getAchternaam();
        this.banknummer = klantDto.getBanknummer();

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    void setNaam(String naam) {
        this.naam = naam;
    }
    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getBanknummer() {
        return banknummer;
    }

    public void setBanknummer(String banknummer) {
        this.banknummer = banknummer;
    }
}
