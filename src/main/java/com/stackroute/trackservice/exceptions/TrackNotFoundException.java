package com.stackroute.trackservice.exceptions;

public class TrackNotFoundException extends Exception {
   private String message;



    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public TrackNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
