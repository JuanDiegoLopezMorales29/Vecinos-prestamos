package com.example.prestamos.repository;

import com.example.prestamos.model.Prestamo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PrestamoRepository extends ReactiveCrudRepository<Prestamo, Integer> {
    Flux<Prestamo> findByObjetoId(Integer objetoId);
    Flux<Prestamo> findByPrestador(String prestador);
    Flux<Prestamo> findByReceptor(String receptor);
}
