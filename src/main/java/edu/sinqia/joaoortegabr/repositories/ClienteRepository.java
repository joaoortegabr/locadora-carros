package edu.sinqia.joaoortegabr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sinqia.joaoortegabr.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
