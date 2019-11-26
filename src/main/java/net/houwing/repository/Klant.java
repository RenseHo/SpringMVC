package net.houwing.repository;

import net.houwing.controller.KlantDto;

import java.util.Objects;

public class Klant {

    private Integer id;
    private String voornaam;
    private String achternaam;
    private String banknummer;

    public Klant() {
    }

    Klant(Integer id, String voornaam, String achternaam) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    Klant(Integer id, String voornaam, String achternaam, String banknummer) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.banknummer = banknummer;
    }

    public Klant(KlantDto klantDto) {
        this.id = klantDto.getId();
        this.voornaam = klantDto.getVoornaam();
        this.achternaam = klantDto.getAchternaam();
        this.banknummer = klantDto.getBanknummer();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Klant klant = (Klant) o;
//        return Objects.equals(getId(), klant.getId()) &&
//                Objects.equals(getVoornaam(), klant.getVoornaam()) &&
//                Objects.equals(getAchternaam(), klant.getAchternaam()) &&
//                Objects.equals(getBanknummer(), klant.getBanknummer());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getVoornaam(), getAchternaam(), getBanknummer());
//    }
}
