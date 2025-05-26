package com.Learning.Let.sLearn.services;

import com.Learning.Let.sLearn.dtos.TrainDTO;
import com.Learning.Let.sLearn.entity.Train;
import com.Learning.Let.sLearn.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    private TrainDTO convertToDTO(Train train) {
        TrainDTO dto = new TrainDTO();
        dto.setId(train.getId());
        dto.setTrainNumber(train.getTrainNumber());
        dto.setName(train.getName());
        dto.setSourceStation(train.getSourceStation());
        dto.setDestinationStation(train.getDestinationStation());
        dto.setCreatedAt(train.getCreatedAt());
        dto.setUpdatedAt(train.getUpdatedAt());
        return dto;
    }

    private Train convertToEntity(TrainDTO trainDTO) {
        Train train = new Train();
        train.setId(trainDTO.getId());
        train.setTrainNumber(trainDTO.getTrainNumber());
        train.setName(trainDTO.getName());
        train.setSourceStation(trainDTO.getSourceStation());
        train.setDestinationStation(trainDTO.getDestinationStation());
        return train;
    }

    public TrainDTO createTrain(TrainDTO trainDTO) {
        Train train = convertToEntity(trainDTO);
        Train savedTrain = trainRepository.save(train);
        return convertToDTO(savedTrain);
    }

    public Optional<TrainDTO> getTrainById(Long id) {
        return trainRepository.findById(id).map(this::convertToDTO);
    }

    public List<TrainDTO> getAllTrains() {
        return trainRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<TrainDTO> updateTrain(Long id, TrainDTO trainDTO) {
        Optional<Train> existingTrain = trainRepository.findById(id);
        if (existingTrain.isPresent()) {
            Train trainToUpdate = convertToEntity(trainDTO);
            trainToUpdate.setId(id);
            Train updatedTrain = trainRepository.save(trainToUpdate);
            return Optional.of(convertToDTO(updatedTrain));
        }
        return Optional.empty();
    }

    public boolean deleteTrain(Long id) {
        if (trainRepository.existsById(id)) {
            trainRepository.deleteById(id);
            return true;
        }
        return false;
    }
}