package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")

public class TrackController {

    private TrackService trackService;


    @Autowired
    public TrackController( TrackService trackService) {
        this.trackService = trackService;
    }

    //Using PostMapping to save the data through Postman
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        //ResponseEntity responseEntity;
            Track savedTrack = trackService.save(track);
            return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
    }

    //Using GetMapping to get the data  by ID through Postman
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException {

            Track retrivedTrack = trackService.getTrackById(id);
            return new ResponseEntity<>(retrivedTrack, HttpStatus.OK);

    }

    //Using GetMapping to get the data through Postman
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    //Using DeleteMapping to delete the data by ID through Postman
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Optional<Track> trackRemoved = Optional.of(trackService.deleteTrackById(id));
        return  new ResponseEntity<>(trackRemoved,HttpStatus.OK);
    }
    //Using PatchMapping to update the data  by ID through Postman
    @PatchMapping("/track/{id}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track, @PathVariable("id") int id) {
        Track track1 = trackService.updateTrackById(track, id);
        return new ResponseEntity < > (track1, HttpStatus.OK);
    }
    //Using getMappiing to get the data  by Name through Postman
    @GetMapping("track/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable("name") String name){
        return new ResponseEntity<>(trackService.getTrackByName(name),HttpStatus.OK);
    }


}
