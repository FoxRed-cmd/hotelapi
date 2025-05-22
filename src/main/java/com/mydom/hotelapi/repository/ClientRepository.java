package com.mydom.hotelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mydom.hotelapi.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
