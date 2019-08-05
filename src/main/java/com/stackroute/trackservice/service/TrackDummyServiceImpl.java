package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Profile("dev")
@Service
@Qualifier("Dummy") //this annotation is used to resolve the autowiring conflict, when there are multiple beans of same type
//@Primary  //this annotation will execute
public class TrackDummyServiceImpl implements TrackService{
    TrackRepository trackRepository;

    @Override
    public Track save(Track track) throws TrackAlreadyExistsException {
       if(trackRepository.existsById(track.getId()))
       {
           throw new TrackAlreadyExistsException("hello");
       }
       return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Track deleteTrackById(int id) {
        return null;
    }

    @Override
    public Track updateTrackById(Track track, int id) {
        return null;
    }

    @Override
    public List<Track> getTrackByName(String name) {
        return null;
    }

}
