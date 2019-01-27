package com.aelastic.xspot.places.controller;

import com.aelastic.xspot.places.models.Place;
import com.aelastic.xspot.places.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Place> postPlace(@Valid @RequestBody Place newPlace){
        Place save = placeService.save(newPlace);
        return new ResponseEntity(save, HttpStatus.CREATED);
    }

    @DeleteMapping("/places/{id}")
    public ResponseEntity deletePlace(@PathVariable String id) {
        try {

            placeService.deletePlaceById(id);
            return ResponseEntity.ok().build();
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/places/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable String id){
        return placeService.findPlaceById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
