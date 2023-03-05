package com.reserva.estacionamento.demo.service;

import com.reserva.estacionamento.demo.modelo.Reserva;
import com.reserva.estacionamento.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarTodasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva buscarReservaPorId(Long id) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        return optionalReserva.orElse(null);
    }

    public Reserva criarReserva(Reserva reserva) {
        reserva.setDataHoraInicio(LocalDateTime.now());
        return reservaRepository.save(reserva);
    }

    public Reserva atualizarReserva(Long id, Reserva reserva) {
        Reserva reservaExistente = buscarReservaPorId(id);
        if (reservaExistente != null) {
            reserva.setId(id);
            reserva.setDataHoraInicio(reservaExistente.getDataHoraInicio());
            return reservaRepository.save(reserva);
        } else {
            return null;
        }
    }

    public boolean excluirReserva(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

