package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {


        @Autowired
        TrackRepository trackRepository;
        Track track;

        @Before
        public void setUp()
        {
            track = new Track();
            track.setId(10);
            track.setName("atul");
            track.setComment("singh");

        }
    @After
    public void tearDown(){
        trackRepository.deleteAll();
    }


}