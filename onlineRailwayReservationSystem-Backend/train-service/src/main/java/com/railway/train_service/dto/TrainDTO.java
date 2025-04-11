package com.railway.train_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDTO {
    private Long id;
    private String trainName;
    private String trainNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double fare;

    // Constructors
    public TrainDTO() {}

    public TrainDTO(Long id, String trainName, String trainNumber, String source, String destination, String departureTime, String arrivalTime, double fare) {
        this.id = id;
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
    }

    // Getters and Setters
}
