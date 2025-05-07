package com.railway.user_service.dto;

import lombok.*;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDTO {
    private Long userId;
    private Long reservationId;
    private List<PassengerDTO> passengers;
    private String sourceStation;
    private String destinationStation;
    private String boardingAtStation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate journeyDate; // Use LocalDate for better date handling

    private String classType;
    private String status;
    private String pnrNumber;
}
