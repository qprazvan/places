package com.aelastic.xspot.places.controller;

import com.aelastic.xspot.places.models.PlaceImage;
import com.aelastic.xspot.places.repository.PlaceImageRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    PlaceImageRepository placeImageRepository;


    @PostMapping("/places/{placeId}/images")
    public ResponseEntity<String> uploadImages(@PathVariable String placeId, @RequestParam("file") MultipartFile image) throws IOException {

        Binary bin = new Binary(image.getBytes());


        PlaceImage placeImage = new PlaceImage(bin, "jpg", placeId);

        placeImage = placeImageRepository.save(placeImage);

        return ResponseEntity.ok(placeImage.getId());
    }

    @GetMapping(value = "/places/{placeId}/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource downloadImage(@PathVariable String placeId, @PathVariable String id) {
//        return  placeImageRepository.findById(id).get();

        return new ByteArrayResource(placeImageRepository.findById(id).get().getFile().getData());
    }
}
