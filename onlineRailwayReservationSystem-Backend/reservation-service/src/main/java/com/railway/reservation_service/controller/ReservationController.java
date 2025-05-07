package com.railway.reservation_service.controller;

import com.railway.reservation_service.dto.ReservationDTO;
import com.railway.reservation_service.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Reservation")
@Slf4j
public class ReservationController {

    private final ReservationService bookingService;

    public ReservationController(ReservationService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/preview")
    public ResponseEntity<ReservationDTO> preview(@RequestParam String username, @RequestParam String trainNumber, @RequestParam int passengers) {
        log.info("Previewing booking for {} on train {}", username, trainNumber);
        return ResponseEntity.ok(bookingService.previewBooking(username, trainNumber, passengers));
    }

    @PostMapping("/confirm")
    public ResponseEntity<ReservationDTO> confirm(@RequestBody ReservationDTO bookingDTO) {
        log.info("Confirming booking for user {}", bookingDTO.getUsername());
        return ResponseEntity.ok(bookingService.confirmBooking(bookingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancel(@PathVariable Long id) {
        double refund = bookingService.cancelBooking(id);
        if (refund > 0) {
            return ResponseEntity.ok("Booking cancelled. Refund amount: " + refund);
        }
        return ResponseEntity.badRequest().body("Invalid booking ID or booking not confirmed.");
    }
}
