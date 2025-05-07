package com.railway.reservation_service.feign;

import com.railway.reservation_service.dto.TrainDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "train-service" , url = "http://localhost:9091")
public interface TrainServiceClient {
    @GetMapping("/trains/{number}")
    TrainDTO getTrainDetails(@PathVariable("number") String number);
}
