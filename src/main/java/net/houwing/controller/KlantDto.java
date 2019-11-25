package net.houwing.controller;

public class KlantDto {

    private Integer id;
    private String naam;
    private String achternaam;
    private String banknummer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
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
