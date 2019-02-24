package com.aelastic.xspot.places.services;

import com.aelastic.xspot.places.models.Table;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface TableService {

    List<Table> getTablesByPlaceId(String id);


    List<Table> saveAll(String id, List<Table> tables) throws ChangeSetPersister.NotFoundException;


    Optional<Table> getTableById(String id);

    void deleteTableById(String tableId) throws ChangeSetPersister.NotFoundException;

    void deleteAll();

}
