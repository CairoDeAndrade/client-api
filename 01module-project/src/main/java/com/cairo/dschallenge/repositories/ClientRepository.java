package com.cairo.dschallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cairo.dschallenge.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
