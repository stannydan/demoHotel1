package com.example.demo.forms;

import com.example.demo.model.Comfort;

public class RoomForm {
    private String id;
    private int number;
    private Comfort comfort;
    private int capacity;
    private int price;
    private boolean busy=false;

    public RoomForm() {
    }

    public RoomForm(int number, Comfort comfort, int capacity, int price) {
        this.number = number;
        this.comfort = comfort;
        this.capacity = capacity;
        this.price = price;
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
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public String toString() {
        return "RoomForm{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", comfort=" + comfort +
                ", capacity=" + capacity +
                ", price=" + price +
                ", busy=" + busy +
                '}';
    }
}
