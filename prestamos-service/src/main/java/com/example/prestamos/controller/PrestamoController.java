package com.example.prestamos.controller;

import com.example.prestamos.controller.dto.PrestamoRequests;
import com.example.prestamos.model.Prestamo;
import com.example.prestamos.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoService service;

    public PrestamoController(PrestamoService service) { this.service = service; }

    @GetMapping
    public Flux<Prestamo> all() { return service.all(); }

    @GetMapping("/{id}")
    public Mono<Prestamo> byId(@PathVariable Integer id) { return service.byId(id); }

    @GetMapping("/objeto/{objetoId}")
    public Flux<Prestamo> byObjeto(@PathVariable Integer objetoId) { return service.byObjeto(objetoId); }

    @GetMapping("/prestador/{prestador}")
    public Flux<Prestamo> byPrestador(@PathVariable String prestador) { return service.byPrestador(prestador); }

    @GetMapping("/receptor/{receptor}")
    public Flux<Prestamo> byReceptor(@PathVariable String receptor) { return service.byReceptor(receptor); }

    @PostMapping
    public Mono<Prestamo> create(@RequestBody @Valid PrestamoRequests.Create req) {
        return service.create(new Prestamo(null, req.prestador(), req.receptor(), req.objetoId(), req.fechaPrestamo()));
    }

    @PutMapping("/{id}")
    public Mono<Prestamo> update(@PathVariable Integer id, @RequestBody @Valid PrestamoRequests.Update req) {
        return service.update(id, new Prestamo(null, req.prestador(), req.receptor(), req.objetoId(), req.fechaPrestamo()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}
