package com.aelastic.xspot.places.controller;

import com.aelastic.xspot.places.models.Place;
import com.aelastic.xspot.places.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PlaceController {

    @Autowired
    PlaceService placeService;
    @GetMapping("/places")
    public List<Place> getPlaces(){
        return placeService.findAll();
    }

    @PostMapping("/places")
    public ResponseEntity<?> postPlace(@Valid @RequestBody Place newPlace){
        return ResponseEntity.ok().body(Optional.of(placeService.save(newPlace)));
//        return ResponseEntity.of(Optional.of(placeService.save(newPlace)));
    }

    @DeleteMapping("/places/{name}")
    public void deletePlace(@PathVariable String name){
         placeService.deletePlaceByName(name);
    }
}
