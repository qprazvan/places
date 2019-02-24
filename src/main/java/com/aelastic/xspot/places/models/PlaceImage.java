package com.aelastic.xspot.places.models;


import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PlaceImage {
    @Id
    private String id;

    @Field
    private Binary file;

    @Field
    private String documentType;

    @Field
    private String placeId;


    public PlaceImage(Binary file, String documentType, String placeId) {
        this.file = file;
        this.documentType = documentType;
        this.placeId = placeId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
