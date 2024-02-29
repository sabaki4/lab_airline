package com.example.airline_api.repositories;

import com.example.airline_api.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAll(); // Display all available flights

    Optional<Flight> findById(long id); // Display specific flight

    Flight getFlightById(Long id);
}
