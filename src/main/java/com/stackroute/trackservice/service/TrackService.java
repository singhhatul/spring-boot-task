package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TrackService {

    //all the methods that have to be implemented
    // 1. save(Track track); save the tracks
    // 2. getTrackById(int id); find track by ID
    // 3. getAllTracks(); find all the tracks
    // 4. deleteTrackById(int id); delete track by ID
    // 5. updateTrackById(Track track,int id); updates the track
    // 6. getTrackByName(); get all the tracks by name

    public Track save(Track track) throws TrackAlreadyExistsException;
    public Track getTrackById(int id) throws TrackNotFoundException;
    public List<Track> getAllTracks();
    public Track deleteTrackById(int id);
    public Track updateTrackById(Track track,int id);
    public List<Track> getTrackByName(String name);

}
