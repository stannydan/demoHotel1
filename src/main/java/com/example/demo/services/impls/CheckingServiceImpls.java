package com.example.demo.services.impls;

import com.example.demo.model.Checking;
import com.example.demo.repository.CheckingRepository;
import com.example.demo.services.interfaces.ICheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckingServiceImpls implements ICheckingService {
    List<Checking> checkings=new ArrayList<>();

    @Autowired
    CheckingRepository repository;

    @Override
    public List<Checking> getAll() {
        return repository.findAll();
    }

    @Override
    public Checking get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Checking create(Checking checking) {
        return repository.save(checking);
    }

    @Override
    public Checking update(Checking checking) {
        return repository.save(checking);
    }

    @Override
    public Checking delete(String id) {
        Checking checking=this.get(id);
        repository.deleteById(id);
        return checking;
    }
}
