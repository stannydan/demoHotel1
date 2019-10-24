package com.example.demo.repository;

import com.example.demo.model.Archive;
import com.example.demo.model.Checking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveRepository extends MongoRepository<Archive,String> {
}
