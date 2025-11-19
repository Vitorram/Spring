package com.link.app.controller;

import com.link.app.dto.EventoDTO;
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

    // Listar todos os eventos (retorna DTO)
    @GetMapping
    public List<EventoDTO> listar() {
        return service.listarTodosDTO();
    }

    // Buscar evento por ID
    @GetMapping("/{id}")
    public EventoDTO buscar(@PathVariable Long id) {
        return service.buscarDTOPorId(id);
    }

    // Criar novo evento
    @PostMapping
    public Evento criar(@RequestBody EventoDTO dto, @RequestParam Long usuarioId, @RequestParam Long alocacaoId) {
        return service.salvar(usuarioId, alocacaoId, dto.toEvento());
    }

    // Atualizar evento existente
    @PutMapping("/{id}")
    public Evento atualizar(@PathVariable Long id, @RequestBody EventoDTO dto, @RequestParam Long usuarioId, @RequestParam Long alocacaoId) {
        return service.atualizar(
                id,
                usuarioId,
                alocacaoId,
                dto.toEvento()
        );
    }

    // Deletar evento
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
