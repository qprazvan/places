package com.aelastic.xspot.places.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "places")
public class Place {
    @Id
    private String id;

    @Indexed
    private String country;

    @Indexed
    private String city;

    @Indexed
    private String name;

    private int totalSeats;



    public Place() {
    }

    public Place(String country, String city, String name, int totalSeats) {
        this.country = country;
        this.city = city;
        this.name = name;
        this.totalSeats = totalSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return totalSeats == place.totalSeats &&
                Objects.equals(id, place.id) &&
                Objects.equals(country, place.country) &&
                Objects.equals(city, place.city) &&
                Objects.equals(name, place.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, name, totalSeats);
    }
}