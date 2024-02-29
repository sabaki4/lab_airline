package com.example.airline_api.repositories;

import com.example.airline_api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

        List<Passenger> findAll(); // Display details of all passengers

        Passenger findById(long id); // Display a specific passenger

    }
