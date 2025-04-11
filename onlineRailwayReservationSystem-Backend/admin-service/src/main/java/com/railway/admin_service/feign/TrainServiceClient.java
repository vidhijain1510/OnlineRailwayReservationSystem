package com.railway.admin_service.feign;

import com.railway.admin_service.dto.TrainDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TrainService")
public interface TrainServiceClient {
    @GetMapping("/trains")
    List<TrainDTO> getAllTrains();

    @GetMapping("/trains/{number}")
    TrainDTO getTrainByNumber(@PathVariable String number);

    @PostMapping("/trains")
    TrainDTO createTrain(@RequestBody TrainDTO dto);

    @PutMapping("/trains/{id}")
    TrainDTO updateTrain(@PathVariable Long id, @RequestBody TrainDTO dto);

    @DeleteMapping("/trains/{id}")
    void deleteTrain(@PathVariable Long id);
}
