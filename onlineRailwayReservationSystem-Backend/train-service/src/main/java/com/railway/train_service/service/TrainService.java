package com.railway.train_service.service;

import com.railway.train_service.dto.TrainDTO;
import com.railway.train_service.model.Train;
import com.railway.train_service.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<TrainDTO> getAllTrains() {
        return trainRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TrainDTO getTrainByNumber(String number) {
        Train train = trainRepository.findByTrainNumber(number);
        return convertToDTO(train);
    }

    @Transactional
    public TrainDTO addTrain(TrainDTO trainDTO) {
        Train saved = trainRepository.save(convertToEntity(trainDTO));
        return convertToDTO(saved);
    }

    public TrainDTO updateTrain(Long id, TrainDTO dto) {
        Train train = trainRepository.findById(id).orElseThrow();
        train.setTrainName(dto.getTrainName());
        train.setTrainNumber(dto.getTrainNumber());
        train.setSource(dto.getSource());
        train.setDestination(dto.getDestination());
        train.setDepartureTime(dto.getDepartureTime());
        train.setArrivalTime(dto.getArrivalTime());
        train.setFare(dto.getFare());
        return convertToDTO(trainRepository.save(train));
    }

    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }

    // Conversion helpers
    private TrainDTO convertToDTO(Train train) {
        return new TrainDTO(
                train.getId(),
                train.getTrainName(),
                train.getTrainNumber(),
                train.getSource(),
                train.getDestination(),
                train.getDepartureTime(),
                train.getArrivalTime(),
                train.getFare()
        );
    }

    private Train convertToEntity(TrainDTO dto) {
        Train train = new Train();
        train.setTrainName(dto.getTrainName());
        train.setTrainNumber(dto.getTrainNumber());
        train.setSource(dto.getSource());
        train.setDestination(dto.getDestination());
        train.setDepartureTime(dto.getDepartureTime());
        train.setArrivalTime(dto.getArrivalTime());
        train.setFare(dto.getFare());
        return train;
    }
}
