package com.railway.user_service.feign;

import com.railway.user_service.dto.ReservationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "reservation-service", url = "http://localhost:9094") // Update URL if needed
public interface ReservationServiceClient {

    @GetMapping("/Reservation/preview")
    ReservationDTO previewBooking(
            @RequestParam String username,
            @RequestParam String trainNumber,
            @RequestParam int passengers);

    @PostMapping("/Reservation/confirm")
    ReservationDTO confirmBooking(@RequestBody ReservationDTO dto);

    @DeleteMapping("/Reservation/cancel/{id}")
    String cancelBooking(@PathVariable Long id);
}

