package net.houwing.services;

import net.houwing.controller.KlantDto;
import net.houwing.repository.Klant;
import net.houwing.repository.KlantenRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class KlantenService {

    private KlantenRepository klantenRepository;

    public KlantenService(KlantenRepository klantenRepository) {
        this.klantenRepository = klantenRepository;
    }

    public String getWelkom() {
        return "Hallo Klant. Welkom.";
    }

    public List<Klant> getKlanten() {
        return klantenRepository.getAlleKlanten();
    }

    public Klant getKlantById(Integer id) {
        Klant klant = null;
        Optional<Klant> collect = klantenRepository.getAlleKlanten().stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        if (collect.isPresent()) {
            klant = collect.get();
        }
        return klant;
    }

    public void addKlant(Klant klant) {
        klantenRepository.addKlant(klant);
    }

    public String delKlantById(Integer id) {
        String message;
        Optional<Klant> collect = klantenRepository.getAlleKlanten().stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        if (collect.isPresent()) {
            Klant klant = collect.get();
            klantenRepository.delKlantById(klant, id);
            message = "Klant verwijderd";
        } else {
            message = "Klant niet gevonden dus niet verwijderd";
        }
        return message;
    }

    public String updKlantById(Integer id, KlantDto klantDto) {
        String message;
        Optional<Klant> collect = klantenRepository.getAlleKlanten().stream()
                //.map(this::klantToKlantDto)
                .filter(item -> item.getId().equals(id))
                .findFirst();
        if (collect.isPresent()) {
            Klant klant = collect.get();
            Klant dtoKlant = KlantMapperImpl.INSTANCE.klantDtoToKlant(klantDto);
            Integer klantId = klant.getId();
            klantenRepository.updateKlantById(klant, dtoKlant);
            message = "Klant geupdate";
        } else {
            message = "Klant niet gevonden dus niet geupdate";
        }
        return message;
    }
}


