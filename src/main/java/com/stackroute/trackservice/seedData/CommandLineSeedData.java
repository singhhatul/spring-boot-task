//package com.stackroute.trackservice.seedData;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.repository.TrackRepository;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
////this class implements coomandlineRunner Interface
//@Component
//public class CommandLineSeedData implements CommandLineRunner {
//    private TrackRepository trackRepository;
//    protected final Log logger = LogFactory.getLog(getClass());
//
//    //contructor of the class
//    @Autowired
//    public CommandLineSeedData(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    //run method i made a object of track and added the values and save it will automatically save
//    // to database runtime
//    @Override
//    public void run(String... args) throws Exception {
//
//        Track track1 = new Track(1, "singh", "atul");
//        Track track2 = new Track(2, "shankar", "pushkar");
//        Track track3 = new Track(3, "maiti", "samresh");
//        Track track4 = new Track(4, "prakash", "shiv");
//
//        //passing the track object
//        trackRepository.save(track1);
//        trackRepository.save(track2);
//        trackRepository.save(track3);
//        trackRepository.save(track4);
//        System.out.println("command line runner working");
//    }
//
//}
