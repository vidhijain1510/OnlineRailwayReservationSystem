package com.railway.reservation_service.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ReservationResponseDTO {
    private String username;
    private String trainNumber;
    private int seatCount;
    private double totalAmount;
    private String status;
}
