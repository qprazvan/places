package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.messagebus.outbox.KafkaTableProducer;
import com.aelastic.xspot.places.models.Place;
import com.aelastic.xspot.places.models.Table;
import com.aelastic.xspot.places.repository.PlaceRepository;
import com.aelastic.xspot.places.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    TableRepository tableRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

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

        Place savedPlace = placeRepository.save(place);

        return savedPlace;
    }

    @Override
    public Optional<Place> findPlaceById(String id) {
        return placeRepository.findById(id);
    }

    @Override
    public void deletePlaceById(String id) throws ChangeSetPersister.NotFoundException {
        boolean exists = placeRepository.existsById(id);
        if (!exists){
            throw new ChangeSetPersister.NotFoundException();
        }
        placeRepository.deleteById(id);
    }


    @Transactional
    public void modifyTables(List<Table> tables) {
        tableRepository.saveAll(tables);

    }

    @Override
    public void checkPlaceByPlaceId(String id) throws ChangeSetPersister.NotFoundException {
        if (!placeRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public void deleteAll() {
        placeRepository.deleteAll();
    }


}