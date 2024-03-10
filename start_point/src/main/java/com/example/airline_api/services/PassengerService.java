package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Transactional
    public Passenger addPassenger(String name, String contact) {
        Passenger passenger = new Passenger(name, contact);
        return passengerRepository.save(passenger);
    }

    @Transactional
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Transactional
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    @Transactional
    public void bookPassengerOnFlight(Long passengerId, Long flightId) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerId);
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);

        if (optionalPassenger.isPresent() && optionalFlight.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            Flight flight = optionalFlight.get();
            passenger.addFlight(flight);
            passengerRepository.save(passenger);
        }
    }

    @Transactional
    public void cancelFlightForPassenger(Long passengerId, Long flightId) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerId);
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);

        if (optionalPassenger.isPresent() && optionalFlight.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            Flight flight = optionalFlight.get();
            passenger.removeFlight(flight);
            passengerRepository.save(passenger);
        }
    }

    @Transactional
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    public Passenger addPassenger(Passenger passenger) {
        return passenger;
    }

    @Transactional
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
