package com.example.demo.services.interfaces;

import com.example.demo.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAll();
    Room get(String id);
    Room create(Room room);
    Room update(Room room);
    Room delete(String id);
}
