package com.stackroute.trackservice.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

////Interface TrackRepository extending JpaRepository to map a function with database
//public interface TrackRepository extends JpaRepository<Track,Integer>{
//
//    //this annotation takes precedence over named queries, which are annotated with @NamedQuery
//    // or defined in an orm.xml file.
//    @Query("select  t from Track t where t.name LIKE ?1")
//    List<Track> getTrackByName(String name);
    public interface TrackRepository extends MongoRepository <Track, Integer> {

    List<Track> getTrackByName(String name);
    }
