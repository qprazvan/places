package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.models.Place;
import com.aelastic.xspot.places.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
@Service
class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceRepository placeRepository;

    @Override
    public List<Place> findByCity(String city) {
        return placeRepository.findByCity(city);
    }

    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> findByName(String name) {
        return placeRepository.findByName(name);
    }

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public void deletePlaceByName(String name) {
        placeRepository.deletePlaceByName(name);
    }


}