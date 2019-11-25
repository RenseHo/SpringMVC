package net.houwing.services;

import net.houwing.controller.KlantDto;
import net.houwing.repository.KlantenModel;
import net.houwing.repository.KlantenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class KlantenService {

    public KlantenRepository klantenRepository;

    @Autowired
    public KlantenService(KlantenRepository klantenRepository) {
        this.klantenRepository = klantenRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public String getWelkom(){
        return "Hallo Klant. Welkom.";
    }

    public List<KlantenModel> getAlleKlantenService() {
        return klantenRepository.getAlleKlantenRepository();
    }

    public List<KlantDto> getAllemaal() {
        List<KlantenModel> klanten = klantenRepository.getAlleKlantenRepository();
        List<KlantDto> collect = klanten.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return collect;
    }


    public String getKlantByIdString(Integer id) {
        String Name = "Geen naam gevonden";
        for (KlantenModel klant : klantenRepository.getAlleKlantenRepository()) {
            if (klant.getId().equals(id)) {
                Name = "Klant met naam : " + klant.getNaam() + " en achternaam : " + klant.getAchternaam() + " gevonden.";
            }
        }
        return Name;
    }

//    public List<KlantenModel> getKlantById(Integer id) {
//        List<KlantenModel> klanten = getAlleKlantenService();
//        List<KlantenModel> resultaat = klanten.stream()
//                .filter(klant -> klant.getId().equals(id))
//                .collect(Collectors.toList());
//        return resultaat;
//    }

    public void addDtoKlant (KlantenModel klantenModel){
        klantenRepository.addKlant(klantenModel);
    }

    public List<KlantDto> getKlantById (Integer id) {
        List<KlantenModel> klanten = klantenRepository.getAlleKlantenRepository();
        List<KlantDto> collect = klanten.stream()
                .map(this::convertToDto)
                .filter(item -> item.getId().equals(id))
                .collect(Collectors.toList());
        return collect;
    }

    private KlantDto convertToDto(KlantenModel klantenModel) {
        KlantDto klantDto = modelMapper.map(klantenModel, KlantDto.class);
        return klantDto;
    }

}

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
