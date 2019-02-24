package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.models.Place;
import com.aelastic.xspot.places.models.Table;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface PlaceService {

    List<Place> findByCity( String city);

    List<Place> findAll();

    List<Place> findByName(String name);

    Place save(Place place);

    Optional<Place> findPlaceById(String id);

    void deletePlaceById(String id) throws ChangeSetPersister.NotFoundException;

    void modifyTables(List<Table> tabless);

    void checkPlaceByPlaceId(String id) throws ChangeSetPersister.NotFoundException;

    void deleteAll();

}
