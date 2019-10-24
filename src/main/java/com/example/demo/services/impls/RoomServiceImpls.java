package com.example.demo.services.impls;

import com.example.demo.model.Comfort;
import com.example.demo.model.Guest;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.services.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpls implements IRoomService {
    List<Room> rooms=new ArrayList<>();

    @Autowired
    RoomRepository repository;

    @PostConstruct
    void init(){
     /*   repository.deleteAll();

        Room first=new Room(1, Comfort.Standart,3,500,true);
        Room second=new Room(2,Comfort.Halflux,2,780,false);
        Room third=new Room(3,Comfort.Lux,2,1200,false);
        rooms.add(first);
        rooms.add(second);
        rooms.add(third);
        repository.saveAll(rooms);*/
    }


    @Override
    public List<Room> getAll() {
        return repository.findAll();
    }

    @Override
    public Room get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Room create(Room room) {
        return repository.save(room);
    }

    @Override
    public Room update(Room room) {
        return repository.save(room);
    }

    public Room getByNum(int num){
       return repository.findByNumber(num).stream().findAny().orElse(null);
    }

    @Override
    public Room delete(String id) {
        Room room=this.get(id);
        repository.deleteById(id);
        return room;
    }
}
