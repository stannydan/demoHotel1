package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Guest {
@Id
private String id;
private String name;
private String forname;
private String passData;
private String comment;

    public Guest() {
    }

    public Guest(String name, String forname, String passData,String comment) {
        this.name = name;
        this.forname = forname;
        this.passData = passData;
        this.comment=comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getPassData() {
        return passData;
    }

    public void setPassData(String passData) {
        this.passData = passData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", forname='" + forname + '\'' +
                ", passData='" + passData + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
