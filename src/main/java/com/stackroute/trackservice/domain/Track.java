package com.stackroute.trackservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
    //variable Declaration
    @Id
    private int id;
    private String name;
    private String comment;

    //default constructor
    public Track() {
    }
    //parameterized Constructor
    public Track(int id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    // All the getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //tostring method
    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
