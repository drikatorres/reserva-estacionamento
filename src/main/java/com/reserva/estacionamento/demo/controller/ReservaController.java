package com.reserva.estacionamento.demo.controller;

import com.reserva.estacionamento.demo.modelo.Reserva;
import com.reserva.estacionamento.demo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarTodasReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.buscarReservaPorId(id);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.criarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva reservaAtualizada = reservaService.atualizarReserva(id, reserva);
        if (reservaAtualizada != null) {
            return ResponseEntity.ok(reservaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (reservaService.excluirReserva(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

