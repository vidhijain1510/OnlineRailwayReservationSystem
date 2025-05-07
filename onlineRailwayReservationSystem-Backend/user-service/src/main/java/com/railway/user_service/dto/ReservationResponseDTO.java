package com.railway.user_service.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationResponseDTO {
    private Long reservationId;
    private String pnrNumber; // ✅ Include this
    private String sourceStation;
    private String destinationStation;
    private String boardingAtStation;

    @JsonFormat(pattern = "yyyy-MM-dd")  // Custom date format if needed
    private LocalDate journeyDate;

    private String classType;
    private String status;
    private List<PassengerDTO> passengers;
}
