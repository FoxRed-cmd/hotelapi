package com.mydom.hotelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mydom.hotelapi.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
