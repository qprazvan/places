package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.models.Place;
import java.util.List;

public interface PlaceService {

    List<Place> findByCity( String city);

    List<Place> findAll();

    List<Place> findByName(String name);

    Place save(Place place);

    void deletePlaceByName(String name);

}
