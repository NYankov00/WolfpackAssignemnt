package guru.springframework.springmvcrest.controllers;

import guru.springframework.springmvcrest.domain.Pack;
import guru.springframework.springmvcrest.domain.Wolf;
import guru.springframework.springmvcrest.services.PackService;
import guru.springframework.springmvcrest.services.WolfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(PackController.BASE_URL)
public class PackController extends MainController {

    public static final String BASE_URL = "/wolfpack/packs";

    private final PackService packService;

    public PackController(PackService packService, WolfService wolfService) {
        super(wolfService);
        this.packService = packService;
    }

    //GET REQUESTS
    @GetMapping
    List<Pack> getAllPacks() {
        return packService.findAllPacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPackById(@PathVariable Long id) {
        try {
            Pack pack = packService.findPackById(id);
            return new ResponseEntity<>(pack, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please provide valid pack id", HttpStatus.NOT_FOUND);
        }
    }

    //CREATE REQUESTS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pack savePack(@RequestBody Pack pack) {
        return packService.savePack(pack);
    }

    //DELETE REQUESTS
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePack(Pack pack) {
        try {
            packService.deletePack(pack);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please provide valid pack id", HttpStatus.NOT_FOUND);
        }
    }

    //Requests for wolves from pack
    @GetMapping("/{id}/wolves")
    public ResponseEntity<?> getAllWolvesFromPack(@PathVariable Long id) {
        try {
            Pack pack = packService.findPackById(id);
            return new ResponseEntity<>(packService.findAllWolves(pack),HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please provide valid pack id", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addWolfToPack(@RequestBody Wolf wolf, @PathVariable Long id) {
        try {
            wolfService.saveWolf(wolf);
            Pack pack = packService.findPackById(id);
            return new ResponseEntity<>(packService.addWolfToPack(pack, wolf),HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please provide valid pack id", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{packId}/wolves/{wolfId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> removeWolfFromPack(@PathVariable Long packId, @PathVariable Long wolfId) {
        try {
            Pack pack = packService.findPackById(packId);
            Wolf wolf = wolfService.findWolfById(wolfId);
            return new ResponseEntity<>(packService.removeWolfFromPack(pack, wolf),HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please provide valid pack id", HttpStatus.NOT_FOUND);
        }
    }
}
