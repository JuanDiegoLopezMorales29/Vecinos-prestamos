package com.example.objetos.service;

import com.example.objetos.model.Objeto;
import com.example.objetos.repository.ObjetoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ObjetoService {
    private final ObjetoRepository repo;

    public ObjetoService(ObjetoRepository repo) {
        this.repo = repo;
    }

    public Flux<Objeto> findAll() { return repo.findAll(); }
    public Mono<Objeto> findById(Integer id) { return repo.findById(id); }
    public Flux<Objeto> findByEstado(String estado) { return repo.findByEstado(estado); }
    public Flux<Objeto> findByTipo(String tipo) { return repo.findByTipo(tipo); }
    public Mono<Objeto> create(Objeto o) { return repo.save(o); }
    public Mono<Objeto> update(Integer id, Objeto o) {
        return repo.findById(id)
            .flatMap(old -> repo.save(new Objeto(id, o.nombre(), o.tipo(), o.estado())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}
