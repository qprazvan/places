package com.aelastic.xspot.places.messagebus.outbox;

import com.aelastic.xspot.places.models.Table;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class KafkaTableProducer {


    public static final String TABLE_TOPIC = "save_table_topic";

    private KafkaTemplate<String, Table> kafkaProducer;

    @Autowired
    public KafkaTableProducer(KafkaTemplate<String, Table> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Async
    public void publishMessage(Table table) {

        String key = table.getPlaceId();
        kafkaProducer.send(new ProducerRecord<>(TABLE_TOPIC, key, table));

    }

}
