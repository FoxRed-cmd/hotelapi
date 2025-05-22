package com.mydom.hotelapi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mydom.hotelapi.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByNumber(String roomNumber);

    void deleteByNumber(String roomNumber);

    Optional<Room> findByNumber(String number);
}
