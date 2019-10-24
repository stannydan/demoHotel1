package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Room {
    @Id
    private String id;
    private int number;
    private Comfort comfort;
    private int capacity;
    private int freePlaces;
    private int price;
    private boolean busy=false;

    public Room() {
    }

    public Room(int number, Comfort comfort, int capacity, int price,boolean busy) {
        this.number = number;
        this.comfort = comfort;
        this.capacity = capacity;
        this.freePlaces=capacity;
        this.price = price;
        this.busy=busy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Comfort getComfort() {
        return comfort;
    }

    public void setComfort(Comfort comfort) {
        this.comfort = comfort;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBusy() {
        return this.busy;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    public void setBusy(boolean busy) {
        busy = busy;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", comfort=" + comfort +
                ", capacity=" + capacity +
                ", price=" + price +
                ", isBusy=" + busy +
                '}';
    }
}
