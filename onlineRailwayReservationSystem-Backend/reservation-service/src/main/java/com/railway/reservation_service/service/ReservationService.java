package com.railway.reservation_service.service;

import com.railway.reservation_service.dto.ReservationDTO;
import com.railway.reservation_service.dto.TrainDTO;
import com.railway.reservation_service.feign.TrainServiceClient;
import com.railway.reservation_service.model.Reservation;
import com.railway.reservation_service.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ReservationService {

    private final ReservationRepository bookingRepository;
    private final TrainServiceClient trainClient;

    public ReservationService(ReservationRepository bookingRepository, TrainServiceClient trainClient) {
        this.bookingRepository = bookingRepository;
        this.trainClient = trainClient;
    }

    public ReservationDTO previewBooking(String username, String trainNumber, int passengers) {
        TrainDTO train = trainClient.getTrainDetails(trainNumber);
        double totalFare = passengers * train.getFare();
        return new ReservationDTO(null, username, trainNumber, passengers, totalFare, false);
    }

    public ReservationDTO confirmBooking(ReservationDTO dto) {
        Reservation booking = new Reservation(null, dto.getUsername(), dto.getTrainNumber(), dto.getPassengers(), dto.getTotalFare(), true);
        bookingRepository.save(booking);
        log.info("Booking confirmed for user: {}", dto.getUsername());
        return new ReservationDTO(booking.getId(), booking.getUsername(), booking.getTrainNumber(), booking.getPassengers(), booking.getTotalFare(), booking.isConfirmed());
    }

    public double cancelBooking(Long id) {
        Optional<Reservation> booking = bookingRepository.findById(id);
        if (booking.isPresent() && booking.get().isConfirmed()) {
            double refund = booking.get().getTotalFare() * 0.8; // example: 80% refund
            bookingRepository.deleteById(id);
            log.info("Booking ID {} cancelled, refund: {}", id, refund);
            return refund;
        }
        return 0.0;
    }
}