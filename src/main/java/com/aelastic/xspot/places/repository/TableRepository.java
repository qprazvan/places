package com.aelastic.xspot.places.repository;

import com.aelastic.xspot.places.models.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TableRepository extends MongoRepository<Table, String> {


}
