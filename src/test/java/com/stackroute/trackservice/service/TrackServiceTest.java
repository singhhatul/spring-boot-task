package com.stackroute.trackservice.service;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
public class TrackServiceTest {
    Track track;
    //Create a mock for TrackRepository
   @Mock
    TrackRepository trackRepository;
    //Inject the mocks as dependencies into TrackServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;
    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        Track track = new Track();
        track.setId(10);
        track.setName("atul");
        track.setComment("singh");
        list = new ArrayList<>();
        list.add(track);
    }
    
    @After
    public void tearDown(){
        this.track=null;
        this.list=null;
    }
    @Test
    public void saveTrackSuccess() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track saveTrack = trackRepository.save(track);
        Assert.assertEquals(track,saveTrack);
        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository,times(1)).save(track);
    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save(track)).thenReturn(null);
        Track saveTrack = trackService.save(track);
        Assert.assertEquals(track, saveTrack);
    }

    @Test
    public void getAllTrack(){
        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        Assert.assertEquals(list,tracklist);
    }
}
