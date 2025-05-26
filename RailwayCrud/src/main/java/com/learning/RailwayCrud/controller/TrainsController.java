package com.learning.RailwayCrud.controller;

import com.learning.RailwayCrud.dto.TrainsDTO;
import com.learning.RailwayCrud.entity.Trains;
import com.learning.RailwayCrud.service.BookingService;
import com.learning.RailwayCrud.service.TrainsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/trains")
public class TrainsController {

    @Autowired
    private TrainsServices trainService;

    @GetMapping("/list")
    private ResponseEntity<List<TrainsDTO>> getAllTrains() {
        try {
            return ResponseEntity.ok(trainService.getAllTrain());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    private ResponseEntity<TrainsDTO> saveTrain(@RequestBody Trains train){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(trainService.saveTrain(train));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<TrainsDTO> getTrainById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(trainService.getTrainById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/")
    private ResponseEntity<TrainsDTO> updateTrain(@RequestBody Trains train){
        try {
            return ResponseEntity.ok(trainService.updateTrain(train));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/")
    private ResponseEntity<Void> deleteTrain(@RequestBody Trains train){
        try {
            trainService.deleteTrain(train);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
