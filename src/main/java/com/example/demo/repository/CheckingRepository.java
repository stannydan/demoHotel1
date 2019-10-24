package com.example.demo.repository;

import com.example.demo.model.Checking;
import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends MongoRepository<Checking,String> {
}
