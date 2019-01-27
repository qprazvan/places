package com.aelastic.xspot.places.repository;

import com.aelastic.xspot.places.models.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {

    List<Place> findByCity(String city);

    List<Place> findByName(String name);



}
