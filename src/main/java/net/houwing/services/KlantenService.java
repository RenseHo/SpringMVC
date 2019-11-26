package net.houwing.services;

import net.houwing.controller.KlantDto;
import net.houwing.repository.Klant;
import net.houwing.repository.KlantenRepository;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<Klant> collect = klantenRepository.getAlleKlanten().stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        //Klant klant = collect.get();

        return collect.get();
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
            //klantenRepository.deleteKlant(klant);
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
            //Integer klantId = klant.getId();
            //Integer klantId = klant.indexOf(dtoId);
            klantenRepository.updateKlantById(klant, dtoKlant);
            message = "Klant geupdate";
        } else {
            message = "Klant niet gevonden dus niet geupdate";
        }
        return message;
    }
}
//    @Override
//    public KlantDto klantToKlantDto(Klant klant) {
//        return null;
//    }
//
//    @Override
//    public Klant klantDtoToKlant(KlantDto klantDto) {
//        return null;
//    }

//    private KlantDto convertToDto (Klant klant) {
//        //KlantDto klantDto = modelMapper.map(klantModel, KlantDto.class);
//        return modelMapper.map(klant, KlantDto.class);
//    }
//
//    private Klant convertFromDto (KlantDto klantDto){
//        return modelMapper.map(klantDto, Klant.class);
//    }

//    public void addDtoKlant (KlantenModel klantenModel){
//        klantenRepository.addKlant(klantenModel);
//    }

//    public List<Post> getPostsList(
//            int page, int size, String sortDir, String sort) {
//
//        PageRequest pageReq
//                = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
//
//        Page<Post> posts = postRepository
//                .findByUser(userService.getCurrentUser(), pageReq);
//        return posts.getContent();
//    }

//    public void addDtoKlant (String naam , String achternaam , String banknummer){
//        klantenRepository.addKlant(naam, achternaam, banknummer);
//    }

//    public List<KlantenModel> getKlantById(Integer id) {
//        List<KlantenModel> klanten = getAlleKlantenService();
//        List<KlantenModel> resultaat = klanten.stream()
//                .filter(klant -> klant.getId().equals(id))
//                .collect(Collectors.toList());
//        return resultaat;
//    }

