package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/v1")
public class TrackController {
    @Autowired
    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.savetrack(track);
            responseEntity = new ResponseEntity<String>("SuccessFully Created", HttpStatus.CREATED);
        }catch(Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }
    @GetMapping("/gettrack")
    public ResponseEntity<?> getAllTracks() {

        ResponseEntity responseEntity;
        try
        {

            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        }catch(Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("/getupdate")
    public ResponseEntity<?> updateComments(@RequestBody Track track) {

        ResponseEntity responseEntity;
        try
        {
             trackService.updateComments(track);
            responseEntity = new ResponseEntity<String>("successfully updated",HttpStatus.OK);
        }catch(Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("/getdelete")
    public ResponseEntity<?> deleteQuery(@RequestBody Track track) {

        ResponseEntity responseEntity;
        try
        {
            trackService.deleteQuery(track);
            responseEntity = new ResponseEntity<String>("Succesfully Deleted",HttpStatus.OK);
        }catch(Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }



}
