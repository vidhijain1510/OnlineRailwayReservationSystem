package com.railway.admin_service.controller;

import com.railway.admin_service.dto.TrainDTO;
import com.railway.admin_service.feign.TrainServiceClient;
import com.railway.admin_service.model.Admin;
import com.railway.admin_service.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private TrainServiceClient trainClient;

    @Autowired
    AdminService adminService;



    private final String trainServiceurl = "http://localhost:9091/trains";

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestParam String username, @RequestParam String password){
        log.info("Attempting login for admin: {}", username);
        if(adminService.login(username, password)){
            return ResponseEntity.ok("login done!");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Interact with TrainService
    @GetMapping("/trains")
    public ResponseEntity<List<TrainDTO>> getAllTrains() {
        log.info("fetching all train details...");
        return ResponseEntity.ok(trainClient.getAllTrains());
    }

    @PostMapping("/trains")
    public ResponseEntity<TrainDTO> createTrain(@RequestBody TrainDTO dto) {
        log.info("posting train data...");
        return ResponseEntity.ok(trainClient.createTrain(dto));
    }

    @PutMapping("/trains/{id}")
    public ResponseEntity<TrainDTO> updateTrain(@PathVariable Long id, @RequestBody TrainDTO dto) {
        log.info("updating train data...");
        return ResponseEntity.ok(trainClient.updateTrain(id, dto));
    }

    @DeleteMapping("/trains/{id}")
    public ResponseEntity<String> deleteTrain(@PathVariable Long id) {
        log.info("attempting to delete data...");
        trainClient.deleteTrain(id);
        return ResponseEntity.ok("Train deleted");
    }
}
