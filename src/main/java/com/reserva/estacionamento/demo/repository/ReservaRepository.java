package com.reserva.estacionamento.demo.repository;

import com.reserva.estacionamento.demo.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
