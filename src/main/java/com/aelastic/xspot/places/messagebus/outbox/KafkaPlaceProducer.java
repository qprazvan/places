package com.aelastic.xspot.places.messagebus.outbox;

import com.aelastic.xspot.places.models.Place;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class KafkaPlaceProducer {


    public static final String PLACE_TOPIC = "save_place_topic";

    private KafkaTemplate<String, Place> kafkaProducer;

//    @Autowired
//    public KafkaPlaceProducer(KafkaTemplate<String, Place> kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

    @Async
    public void publishMessage(Place place) {

        String key = place.getCountry() + place.getCity();
//        kafkaProducer.send(new ProducerRecord<>(PLACE_TOPIC, key, place));

    }

}
