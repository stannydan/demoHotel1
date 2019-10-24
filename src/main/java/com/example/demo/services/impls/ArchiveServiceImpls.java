package com.example.demo.services.impls;

import com.example.demo.model.Archive;
import com.example.demo.model.Checking;
import com.example.demo.repository.ArchiveRepository;
import com.example.demo.services.interfaces.IArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArchiveServiceImpls implements IArchiveService {
    List<Archive> archives=new ArrayList<>();

    @Autowired
    ArchiveRepository repository;

    @Override
    public List<Archive> getAll() {
        return repository.findAll();
    }

    @Override
    public Archive create(Archive archive) {
        return repository.save(archive);
    }

    @Override
    public Archive get(String id) {
        return repository.findById(id).orElse(null);
    }
}
