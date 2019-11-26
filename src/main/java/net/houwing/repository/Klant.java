package net.houwing.repository;

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

}
