//package com.stackroute.trackservice.seedData;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
////this class implements Application Listener Interface
//@Component
//public class ApplicationListenerSeedData implements ApplicationListener<ContextRefreshedEvent> {
//    private TrackRepository trackRepository;
//
//    //contructor of class ApplicationListen
//    @Autowired
//    public ApplicationListenerSeedData(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    //onApplicationEvent method i made a object of track and added the values and save it will automatically save
//    // to database runtime
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        System.out.println("Application Event running");
//        Track track1 = new Track(24, "atul", "singh");
//        Track track2 = new Track(25, "pushkar", "shankar");
//        Track track3 = new Track(26, "samresh", "maiti");
//        Track track4 = new Track(27, "shiv", "prakash");
//
//        //passing the track object
//        trackRepository.save(track1);
//        trackRepository.save(track2);
//        trackRepository.save(track3);
//        trackRepository.save(track4);
//    }
//}