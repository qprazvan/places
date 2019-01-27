package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.messagebus.outbox.KafkaTableProducer;
import com.aelastic.xspot.places.models.Table;
import com.aelastic.xspot.places.repository.PlaceRepository;
import com.aelastic.xspot.places.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private KafkaTableProducer kafkaTableProducer;

    @Override
    public List<Table> getTablesByPlaceId(String id) {
        return tableRepository.findAllByPlaceId(id);
    }

    @Override
    public List<Table> saveAll(String id, List<Table> tables) throws ChangeSetPersister.NotFoundException {
        if (placeRepository.existsById(id)) {

            List<Table> tableList = tableRepository.saveAll(tables);
            tableList.forEach(kafkaTableProducer::publishMessage);
            return tableList;
        }
        throw new ChangeSetPersister.NotFoundException();

    }

    @Override
    public Optional<Table> getTableById(String id) {

        return tableRepository.findById(id);
    }

    @Override
    public void deleteTableById(String tableId) throws ChangeSetPersister.NotFoundException {
        boolean exists = tableRepository.existsById(tableId);
        if (!exists) {
            throw new ChangeSetPersister.NotFoundException();
        }
        tableRepository.deleteById(tableId);
    }
}
