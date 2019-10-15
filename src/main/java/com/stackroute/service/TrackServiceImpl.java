package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository= trackRepository;
    }
    @Override
    public Track savetrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateComments(Track track) {
        Track updateTrack = trackRepository.getOne(track.getTrackId());
        updateTrack.setTrackComments(track.getTrackComments());
        trackRepository.save(updateTrack);
        return updateTrack;
    }

    @Override
    public void deleteQuery(Track track) {
        trackRepository.delete(track);

    }


}
