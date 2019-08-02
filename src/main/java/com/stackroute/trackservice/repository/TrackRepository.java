package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface TrackRepository extending JpaRepository to map a function with database
public interface TrackRepository extends JpaRepository<Track,Integer>{

}
