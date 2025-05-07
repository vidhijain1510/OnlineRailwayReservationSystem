package com.railway.user_service.service;

import com.railway.user_service.dto.ReservationDTO;
import com.railway.user_service.dto.UserDTO;
import com.railway.user_service.feign.ReservationServiceClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ReservationServiceClient reservationServiceClient;

    public UserService(ReservationServiceClient reservationServiceClient) {
        this.reservationServiceClient = reservationServiceClient;
    }

    // Registration logic
    public String register(UserDTO userDTO) {
        // Implement registration logic here
        return "User registered successfully";
    }

    // Login logic
    public String login(UserDTO userDTO) {
        // Implement login logic here
        return "Login successful";
    }

    // Preview booking
    public ReservationDTO previewBooking(String username, String trainNumber, int passengers) {
        return reservationServiceClient.previewBooking(username, trainNumber, passengers);
    }

    // Confirm booking
    public ReservationDTO confirmBooking(ReservationDTO dto) {
        return reservationServiceClient.confirmBooking(dto);
    }

    // Cancel booking
    public String cancelBooking(Long id) {
        return reservationServiceClient.cancelBooking(id);
    }
}
