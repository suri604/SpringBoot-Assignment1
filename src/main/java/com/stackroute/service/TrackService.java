package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {
    public Track savetrack(Track track);
    public List<Track> getAllTracks();
    public Track updateComments(Track track);
    public void deleteQuery(Track track);
}
