package com.railway.admin_service.dto;

import lombok.Data;

@Data
public class TrainDTO {
    private Long id;
    private String trainName;
    private String trainNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double fare;
}
