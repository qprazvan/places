package com.aelastic.xspot.places.repository;

import com.aelastic.xspot.places.models.PlaceImage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceImageRepository extends MongoRepository<PlaceImage, String> {
    List<PlaceImage> findAllByPlaceId(String placeId);

}
