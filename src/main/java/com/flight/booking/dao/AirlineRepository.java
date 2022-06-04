package com.flight.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
