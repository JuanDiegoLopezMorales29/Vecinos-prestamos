package com.example.prestamos.service;

import com.example.prestamos.model.Prestamo;
import com.example.prestamos.repository.PrestamoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrestamoService {
    private final PrestamoRepository repo;

    public PrestamoService(PrestamoRepository repo) { this.repo = repo; }

    public Flux<Prestamo> all() { return repo.findAll(); }
    public Mono<Prestamo> byId(Integer id) { return repo.findById(id); }
    public Flux<Prestamo> byObjeto(Integer objetoId) { return repo.findByObjetoId(objetoId); }
    public Flux<Prestamo> byPrestador(String prestador) { return repo.findByPrestador(prestador); }
    public Flux<Prestamo> byReceptor(String receptor) { return repo.findByReceptor(receptor); }
    public Mono<Prestamo> create(Prestamo p) { return repo.save(p); }
    public Mono<Prestamo> update(Integer id, Prestamo p) {
        return repo.findById(id).flatMap(old -> repo.save(new Prestamo(id, p.prestador(), p.receptor(), p.objetoId(), p.fechaPrestamo())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}
