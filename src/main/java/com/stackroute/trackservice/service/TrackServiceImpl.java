package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Profile("prod")
@Service
//@Qualifier("TrackServiceImpl")
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //implementation of saveTrack() method
    @Override
    public Track save(Track track) throws TrackAlreadyExistsException {
        Track savedTrack=null;
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track is already exists");
        }
        else {
            savedTrack = trackRepository.save(track);
            if (savedTrack == null) {
                throw new TrackAlreadyExistsException("null");
            }
        }
        return savedTrack;
    }
    //implementation  of getTrackById() method
    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track not found ");
        }
        Track retrievedTrack=trackRepository.findById(id).get();
        return retrievedTrack;
    }

    //implementation  of getAllTracks() method
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    //implementation  of deleteTrackById() method
    @Override
    public Track deleteTrackById(int id) {
        Optional <Track> optionalTrack = trackRepository.findById(id);
        trackRepository.deleteById(id);
        return optionalTrack.get();
    }
    //implementation  of updateTrackByID() method
    @Override
    public Track updateTrackById(Track track, int id) {
        trackRepository.deleteById(id);
        return trackRepository.save(track);
    }
    //implementation  of getTrackByName method
    @Override
    public List<Track> getTrackByName(String name) {
        return (List<Track>) trackRepository.getTrackByName(name);
    }
}
