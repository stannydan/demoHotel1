package com.example.demo.services.interfaces;

import com.example.demo.model.Checking;

import java.util.List;

public interface ICheckingService {
    List<Checking> getAll();
    Checking get(String id);
    Checking create(Checking checking);
    Checking update(Checking checking);
    Checking delete(String id);
}
