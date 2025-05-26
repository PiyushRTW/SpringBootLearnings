package com.learning.RailwayCrud.service.implementation;

import com.learning.RailwayCrud.dto.TrainsDTO;
import com.learning.RailwayCrud.entity.Trains;
import com.learning.RailwayCrud.repository.TrainsRepository;
import com.learning.RailwayCrud.service.TrainsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainServicesImpl implements TrainsServices {

    @Autowired
    private TrainsRepository trainsRepository;

    private TrainsDTO mapTraintoDTO(Trains train){
        TrainsDTO traindto = new TrainsDTO();
        traindto.setTrainId(train.getTrainId());
        traindto.setTrain_No(train.getTrain_No());
        traindto.setTrain_Name(train.getTrain_Name());
        traindto.setTrain_Type(train.getTrain_Type());
        return traindto;
    }

    @Override
    public List<TrainsDTO> getAllTrain() {
        List<Trains> trainList = trainsRepository.findAll();
        List<TrainsDTO> trains = new ArrayList<>();

        for(Trains train : trainList){
            trains.add(mapTraintoDTO(train));
        }
        return trains;
    }

    @Override
    public TrainsDTO saveTrain(Trains train) {
        Trains savedtrains = trainsRepository.save(train);
        return this.mapTraintoDTO(savedtrains);
    }

    @Override
    public TrainsDTO getTrainById(Long id) {
        Optional<Trains> trainsOptional = trainsRepository.findById(id);
        if(trainsOptional.isPresent()){
            return this.mapTraintoDTO(trainsOptional.get());
        }
        else{
            return null;
        }
    }

    @Override
    public TrainsDTO updateTrain(Trains train) {
        Trains Updatedtrains = trainsRepository.save(train);
        return this.mapTraintoDTO(Updatedtrains);
    }

    @Override
    public void deleteTrain(Trains train) {
        trainsRepository.delete(train);
    }
}
