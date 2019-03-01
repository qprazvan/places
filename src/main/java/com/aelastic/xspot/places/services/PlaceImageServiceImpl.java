package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.models.PlaceImage;
import com.aelastic.xspot.places.repository.PlaceImageRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class PlaceImageServiceImpl implements PlaceImageService {


    PlaceImageRepository placeImageRepository;

    @Autowired
    public PlaceImageServiceImpl(PlaceImageRepository placeImageRepository) {
        this.placeImageRepository = placeImageRepository;
    }

    @Override
    public List<PlaceImage> getImagesByPlaceId(String placeId) {
        return placeImageRepository.findAllByPlaceId(placeId);
    }

    @Override
    public Optional<PlaceImage> getImageById(String id) {
        return placeImageRepository.findById(id);
    }

    @Override
    public String saveImage(MultipartFile multipartFile, String placeId) throws IOException {
        Binary binaryImage = new Binary(multipartFile.getBytes());
        PlaceImage placeImage = new PlaceImage(binaryImage, "JPG", placeId);
        placeImage = placeImageRepository.save(placeImage);
        return placeImage.getId();
    }
}
