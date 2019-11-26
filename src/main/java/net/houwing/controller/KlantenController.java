package net.houwing.controller;

import net.houwing.repository.Klant;
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

    @GetMapping(value = "/welkom")  //, produces = MediaType.APPLICATION_JSON_VALUE
    public String welkom() {
        return klantenService.getWelkom();
    }

    @GetMapping
    public ResponseEntity<List<Klant>> klanten() {
        return ResponseEntity.ok(klantenService.getKlanten());
    }

    @RequestMapping(value = "/{idNr}", method = RequestMethod.GET)
    // @ResponseBody automatisch bij RestController
    public Klant klantById(@PathVariable("idNr") Integer id) {
        return klantenService.getKlantById(id);
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Klant> addKlant(@RequestBody Klant klant) {
        klantenService.addKlant(klant);
        return ResponseEntity.ok(klant);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable Integer id) {
        return klantenService.delKlantById(id);
    }

    @PutMapping(value = "/{id}")
    public String updateById(@PathVariable(value = "id") Integer id, @RequestBody KlantDto klantDto) {
        return klantenService.updKlantById(id, klantDto);
    }

}
