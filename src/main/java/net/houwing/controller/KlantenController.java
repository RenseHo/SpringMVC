package net.houwing.controller;

import net.houwing.repository.KlantModel;
import net.houwing.services.KlantenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klanten")
public class KlantenController {

    private KlantenService klantenService;

    @Autowired
    public KlantenController(KlantenService klantenService) {
        this.klantenService = klantenService;
    }

    @GetMapping(value = "/welkom", produces = MediaType.APPLICATION_JSON_VALUE)
    public String welkom (){
        return klantenService.getWelkom();
    }

    @GetMapping(value ="/all")      //, produces = MediaType.APPLICATION_JSON_VALUE
     public ResponseEntity<List<KlantModel>> getKlantenAll() {
        return ResponseEntity.ok(klantenService.getAlleKlantenService());
    }

    @RequestMapping(value ="/alltwee", method = RequestMethod.GET)      //, produces = MediaType.APPLICATION_JSON_VALUE
    public ResponseEntity<List<KlantModel>> getKlantentwee() {
        return ResponseEntity.ok(klantenService.getAlleKlantenService());
    }

    @PostMapping(path = "/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KlantModel> addKlant (@RequestBody KlantModel klantModel) {
        klantenService.addKlant(klantModel);
        return ResponseEntity.ok(klantModel);
    }

    @RequestMapping(value = "/allemaal",method = RequestMethod.GET)
    @ResponseBody
    public List<KlantDto> getKlanten() {
        return klantenService.getAllemaal();
    }


    @RequestMapping(value = "/{idNr}", method = RequestMethod.GET)
    @ResponseBody
    public List<KlantDto> getKlantenModel(@PathVariable("idNr") Integer id) {
        return klantenService.getKlantById(id);
    }


//    // http://localhost:8080/Spring-1/addklantdrie?naam=Jan&achternaam=Jansen&banknummer=99-88-77-654
//    @PostMapping(path = "/addklantdrie")
//    public void addKlantdrie (@RequestParam("naam") String naam, @RequestParam("achternaam") String achternaam, @RequestParam("banknummer") String banknummer) {
//        klantenService.addDtoKlant(naam,achternaam,banknummer);
//    }

}
