package guru.springframework.springmvcrest.controllers;

import guru.springframework.springmvcrest.domain.Wolf;
import guru.springframework.springmvcrest.services.WolfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(WolfController.BASE_URL)
public class WolfController extends MainController {

    public static final String BASE_URL = "/wolfpack/wolves";

    public WolfController(WolfService wolfService) {
        super(wolfService);
    }

    //GET REQUESTS
    @GetMapping
    List<Wolf> getAllWolves() {
        return wolfService.findAllWolves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWolfById(@PathVariable Long id) {
        try {
            Wolf wolf = wolfService.findWolfById(id);
            return new ResponseEntity<>(wolf, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please provide valid wolf id", HttpStatus.NOT_FOUND);
        }
    }

    //CREATE REQUESTS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Wolf saveWolf(@RequestBody Wolf wolf) {
        return wolfService.saveWolf(wolf);
    }

    //UPDATE REQUESTS
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateWolfLocation(@RequestBody Wolf wolf, @PathVariable Long id) {
        if (wolfService.updateWolfLocation(wolf)) {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Please provide valid wolf id", HttpStatus.NOT_FOUND);
        }
    }

    //DELETE REQUESTS
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteWolf(Wolf wolf) {
        try {
            wolfService.deleteWolf(wolf);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please provide valid wolf id", HttpStatus.NOT_FOUND);
        }
    }
}






