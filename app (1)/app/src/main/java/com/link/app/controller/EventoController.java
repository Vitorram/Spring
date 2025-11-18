package com.link.app.controller;

import com.link.app.model.Evento;
import com.link.app.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public List<Evento> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Evento buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Evento criar(@RequestBody Evento evento) {
        return service.salvar(evento);
    }

    @PutMapping("/{id}")
    public Evento atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        return service.atualizar(id, evento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
