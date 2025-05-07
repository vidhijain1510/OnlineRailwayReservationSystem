package com.railway.user_service.controller;

import com.railway.user_service.dto.ReservationDTO;
import com.railway.user_service.dto.UserDTO;
import com.railway.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        log.info("Registering user: {}", userDTO.getUsername());
        return ResponseEntity.ok(userService.register(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        log.info("User login attempt: {}", userDTO.getUsername());
        return ResponseEntity.ok(userService.login(userDTO));
    }

    @GetMapping("/preview")
    public ResponseEntity<ReservationDTO> previewBooking(
            @RequestParam String username,
            @RequestParam String trainNumber,
            @RequestParam int passengers) {
        return ResponseEntity.ok(userService.previewBooking(username, trainNumber, passengers));
    }

    @PostMapping("/confirm")
    public ResponseEntity<ReservationDTO> confirmBooking(@RequestBody ReservationDTO dto) {
        return ResponseEntity.ok(userService.confirmBooking(dto));
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(userService.cancelBooking(id));
    }
}
