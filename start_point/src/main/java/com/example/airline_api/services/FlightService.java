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
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Transactional
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Transactional
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Transactional
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    @Transactional
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id).get();
        for (Passenger chocolate : flight.getPassengers()){
            chocolate.removeFlight(flight);
            passengerRepository.save(chocolate);
        }
        flightRepository.delete(flight);
    }

    public Flight addPassengerToFlight(Long flightId, Long passengerId) {
        return null;
    }

}
