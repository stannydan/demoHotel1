package com.example.demo.forms;

import java.time.LocalDate;

public class CheckingForm {
    private String id;
    private String guest;
    private String room;
    private String checkIn;
    private String checkOut;
    private String reserved;


    public CheckingForm() {
    }

    public CheckingForm(String guest, String room, String checkIn, String checkOut,String reserved) {
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.reserved = reserved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "CheckingForm{" +
                "id='" + id + '\'' +
                ", guest='" + guest + '\'' +
                ", room='" + room + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", Reserved=" + reserved +
                '}';
    }
}
