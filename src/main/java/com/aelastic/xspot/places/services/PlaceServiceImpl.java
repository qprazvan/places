package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.models.Place;
import com.aelastic.xspot.places.models.Table;
import com.aelastic.xspot.places.repository.PlaceRepository;
import com.aelastic.xspot.places.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
@Service
class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    TableRepository tableRepository;

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


    @Transactional
    public void modifyTables(List<Table> tables) {
        tableRepository.saveAll(tables);

    }


}