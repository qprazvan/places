package com.aelastic.xspot.places.controller;

import com.aelastic.xspot.places.models.Place;
import com.aelastic.xspot.places.models.Table;
import com.aelastic.xspot.places.services.PlaceService;
import com.aelastic.xspot.places.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @Autowired
    TableService tableService;


    @GetMapping("/")
    public List<Place> getPlaces(){
        return placeService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Place> postPlace(@Valid @RequestBody Place newPlace){
        Place save = placeService.save(newPlace);
        return new ResponseEntity(save, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlace(@PathVariable String id) {
        try {
            placeService.deletePlaceById(id);
            return ResponseEntity.ok().build();
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable String id){
        return placeService.findPlaceById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/tables")
    public List<Table> getTablesByPlaceId(@PathVariable String id) {
        return tableService.getTablesByPlaceId(id);
    }

    @PostMapping(value = "/{id}/tables")
    public ResponseEntity<List<Table>> postTables(@PathVariable String id, @RequestBody List<Table> tables) {
        List<Table> tableList = null;
        try {
            tableList = tableService.saveAll(id, tables);
            placeService.checkPlaceByPlaceId(id);
            return new ResponseEntity(tableList, HttpStatus.CREATED);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(tableList, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("{id}/tables/{tableId}")
    public ResponseEntity<Table> getTableById(@PathVariable String id, @PathVariable String tableId) {
        return tableService.getTableById(tableId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}/tables/{tableId}")
    public ResponseEntity deleteTable(@PathVariable String id, @PathVariable String tableId) {

        try {
            tableService.deleteTableById(tableId);
            return ResponseEntity.ok().build();
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity.notFound().build();

    }





}
