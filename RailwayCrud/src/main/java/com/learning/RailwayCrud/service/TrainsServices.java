package com.learning.RailwayCrud.service;
import com.learning.RailwayCrud.dto.TrainsDTO;
import com.learning.RailwayCrud.entity.Trains;

import java.util.List;

public interface TrainsServices {

    List<TrainsDTO> getAllTrain();

    TrainsDTO saveTrain(Trains train);

    TrainsDTO getTrainById(Long id);

    TrainsDTO updateTrain(Trains train);

    void deleteTrain(Trains train);
}
