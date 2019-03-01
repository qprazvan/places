package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.models.PlaceImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PlaceImageService {


    List<PlaceImage> getImagesByPlaceId(String placeId);

    Optional<PlaceImage> getImageById(String id);

    String saveImage(MultipartFile multipartFile, String placeId) throws IOException;

}
