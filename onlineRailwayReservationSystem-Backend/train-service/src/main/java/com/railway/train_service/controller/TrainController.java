package com.railway.train_service.controller;

import com.railway.train_service.dto.TrainDTO;
import com.railway.train_service.service.TrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/trains")
@CrossOrigin
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public ResponseEntity<List<TrainDTO>> getAllTrains() {
        log.info("giving all train details!");
        return ResponseEntity.ok(trainService.getAllTrains());
    }

    @GetMapping("/{number}")
    public ResponseEntity<TrainDTO> getTrain(@PathVariable String number) {
        log.info("giving train with number: {}", number);
        return ResponseEntity.ok(trainService.getTrainByNumber(number));
    }

    @PostMapping
    public ResponseEntity<TrainDTO> createTrain(@RequestBody TrainDTO trainDTO) {
        log.info("posted train data!");
        return ResponseEntity.ok(trainService.addTrain(trainDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainDTO> updateTrain(@PathVariable Long id, @RequestBody TrainDTO dto) {
        log.info("updated train data with id: {}", id);
        return ResponseEntity.ok(trainService.updateTrain(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrain(@PathVariable Long id) {
        trainService.deleteTrain(id);
        log.info("deleted train data with id: {}" , id);
        return ResponseEntity.ok("Train deleted");
    }
}
