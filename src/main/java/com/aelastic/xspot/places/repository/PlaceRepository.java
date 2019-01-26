package com.aelastic.xspot.places.repository;

import com.aelastic.xspot.places.models.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {

//    @Query(value = "SELECT * from place where city= :city", nativeQuery = true)
//    List<Place> findByCity(@Param("city") String city);

    List<Place> findByCity(String city);

    List<Place> findAll();

    List<Place> findByName(String name);

    Place save(Place place);

//    @Transactional
//    @Modifying
//    @Query(value = "delete from place where name = :name", nativeQuery = true)
//    void deletePlaceByCity(@Param("name") String name);

    @Transactional
    default void deletePlaceByName(String name) {

    }


}
