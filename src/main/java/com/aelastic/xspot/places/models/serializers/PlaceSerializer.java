package com.aelastic.xspot.places.models.serializers;

import com.aelastic.xspot.places.models.Place;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class PlaceSerializer implements Serializer<Place> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Place place) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsBytes(place);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
