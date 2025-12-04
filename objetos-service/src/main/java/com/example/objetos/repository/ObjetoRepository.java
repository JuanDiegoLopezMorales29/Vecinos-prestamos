package com.example.objetos.repository;

import com.example.objetos.model.Objeto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ObjetoRepository extends ReactiveCrudRepository<Objeto, Integer> {
    Flux<Objeto> findByEstado(String estado);
    Flux<Objeto> findByTipo(String tipo);
}
