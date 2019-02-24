package com.aelastic.xspot.places;

import com.aelastic.xspot.places.services.PlaceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlacesApplication.class)
public class PlacesApplicationTests {
    @Autowired
    PlaceService placeService;
    @Test
    public void contextLoads() {


    }

}

