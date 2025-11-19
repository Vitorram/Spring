package com.link.app.controller;

import com.link.app.model.Alocacao;
import com.link.app.service.AlocacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alocacoes")
@CrossOrigin("*")
public class AlocacaoController {

    private final AlocacaoService service;

    public AlocacaoController(AlocacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alocacao> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Alocacao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Criar nova alocação, recebe opcionalmente o id do usuário
    @PostMapping
    public Alocacao criar(@RequestBody Alocacao alocacao, @RequestParam(required = false) Long usuarioId) {
        // Aqui futuramente você pode setar o usuarioId na alocacao
        return service.salvar(alocacao);
    }

    // Atualizar alocação existente, recebe opcionalmente o id do usuário
    @PutMapping("/{id}")
    public Alocacao atualizar(@PathVariable Long id, @RequestBody Alocacao alocacao, @RequestParam(required = false) Long usuarioId) {
        // Aqui futuramente você pode atualizar o usuarioId na alocacao
        return service.atualizar(id, alocacao);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
