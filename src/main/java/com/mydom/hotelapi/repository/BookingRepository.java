package com.mydom.hotelapi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mydom.hotelapi.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT b.* FROM Booking b WHERE b.room_id = :room_id AND b.status IN ('Ожидание оплаты', 'Подтверждено')",
            nativeQuery = true)
    Optional<Booking> findActiveBookingByRoomId(@Param("room_id") Long roomId);
}
