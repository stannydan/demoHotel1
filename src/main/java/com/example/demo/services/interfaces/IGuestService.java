package com.example.demo.services.interfaces;

import com.example.demo.model.Guest;

import java.util.List;

public interface IGuestService {
    List<Guest> getAll();
    Guest get(String id);
    Guest create(Guest guest);
    Guest update(Guest guest);
    Guest delete(String id);
}
