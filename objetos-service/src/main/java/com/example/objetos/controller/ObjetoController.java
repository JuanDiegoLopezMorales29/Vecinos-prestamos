package com.example.objetos.controller;

import com.example.objetos.controller.dto.ObjetoRequests;
import com.example.objetos.model.Objeto;
import com.example.objetos.service.ObjetoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/objetos")
public class ObjetoController {
    private final ObjetoService service;

    public ObjetoController(ObjetoService service) { this.service = service; }

    @GetMapping
    public Flux<Objeto> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Mono<Objeto> byId(@PathVariable Integer id) { return service.findById(id); }

    @GetMapping("/estado/{estado}")
    public Flux<Objeto> byEstado(@PathVariable String estado) { return service.findByEstado(estado); }

    @GetMapping("/tipo/{tipo}")
    public Flux<Objeto> byTipo(@PathVariable String tipo) { return service.findByTipo(tipo); }

    @PostMapping
    public Mono<Objeto> create(@RequestBody @Valid ObjetoRequests.Create req) {
        return service.create(new Objeto(null, req.nombre(), req.tipo(), req.estado()));
    }

    @PutMapping("/{id}")
    public Mono<Objeto> update(@PathVariable Integer id, @RequestBody @Valid ObjetoRequests.Update req) {
        return service.update(id, new Objeto(null, req.nombre(), req.tipo(), req.estado()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}
