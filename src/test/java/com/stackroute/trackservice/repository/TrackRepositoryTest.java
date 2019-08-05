package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {


    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp() {
        track = new Track();
        track.setId(1);
        track.setName("atul");
        track.setComment("singh");

    }

    @After
    public void tearDown() {
        trackRepository.deleteAll();
    }
    @Test
    public void testSavetrack(){
        trackRepository.save(track);
        Track fetchtrack = trackRepository.findById(track.getId()).get();
        System.out.println(fetchtrack);
        Assert.assertEquals(1,fetchtrack.getId());

    }

    @Test
    public void testSavetrackFailure() {
        Track testtrack = new Track(1, "atul", "singh");
        trackRepository.save(track);
        Track fetchtrack = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testtrack, track);
    }

    @Test
    public void testGetAlltrack(){
        Track u = new Track(1,"atul","kumar");
        Track u1 = new Track(3,"samresh","maiti");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("atul",list.get(0).getName());

    }
}