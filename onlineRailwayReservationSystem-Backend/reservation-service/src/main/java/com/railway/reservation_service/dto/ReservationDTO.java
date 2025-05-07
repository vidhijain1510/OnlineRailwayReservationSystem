package com.railway.reservation_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long id;
    private String username;
    private String trainNumber;
    private int passengers;
    private double totalFare;
    private boolean confirmed;
}

