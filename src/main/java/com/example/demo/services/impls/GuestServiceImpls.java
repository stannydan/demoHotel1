package com.example.demo.services.impls;

import com.example.demo.model.Guest;
import com.example.demo.repository.GuestRepository;
import com.example.demo.services.interfaces.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class GuestServiceImpls implements IGuestService {
    List<Guest> guests=new ArrayList<>();

@Autowired
    GuestRepository repository;

    @PostConstruct
    void init(){
      /*  repository.deleteAll();

        Guest nick=new Guest("Niccolo","Paganini","IT2871GE","");
        Guest gustav=new Guest("Gustav","Mahler","AU0681VI","");
        Guest ludwig=new Guest("Ludwig","Bethoven","DE0771BO","");
        guests.add(nick);
        guests.add(gustav);
        guests.add(ludwig);
        repository.saveAll(guests);*/
    }

    @Override
    public List<Guest> getAll() {
        return repository.findAll();
    }

    @Override
    public Guest get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Guest create(Guest guest) {
        return repository.save(guest);
    }

    @Override
    public Guest update(Guest guest) {
        return repository.save(guest);
    }

    @Override
    public Guest delete(String id) {
        Guest guest=repository.findById(id).orElse(null);
        repository.deleteById(id);
        return guest;
    }
}
