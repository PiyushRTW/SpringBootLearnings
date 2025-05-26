package com.Learning.Let.sLearn.controllers;

import com.Learning.Let.sLearn.dtos.TrainDTO;
import com.Learning.Let.sLearn.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
    public ResponseEntity<TrainDTO> createTrain(@RequestBody TrainDTO trainDTO) {
        TrainDTO createdTrain = trainService.createTrain(trainDTO);
        return new ResponseEntity<>(createdTrain, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainDTO> getTrainById(@PathVariable Long id) {
        Optional<TrainDTO> trainDTO = trainService.getTrainById(id);
        return trainDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TrainDTO>> getAllTrains() {
        List<TrainDTO> trains = trainService.getAllTrains();
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainDTO> updateTrain(@PathVariable Long id, @RequestBody TrainDTO trainDTO) {
        Optional<TrainDTO> updatedTrainDTO = trainService.updateTrain(id, trainDTO);
        return updatedTrainDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
        if (trainService.deleteTrain(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}