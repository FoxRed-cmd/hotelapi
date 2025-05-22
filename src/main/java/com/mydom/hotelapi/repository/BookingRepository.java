package com.mydom.hotelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mydom.hotelapi.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
