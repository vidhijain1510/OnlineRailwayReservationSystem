package com.railway.train_service.repository;

import com.railway.train_service.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findByTrainNumber(String trainNumber);
}
