package com.link.app.controller;

import com.link.app.model.Alocacao;
import com.link.app.service.AlocacaoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alocacoes")
@CrossOrigin(origins = "*") // Se quiser deixo igual eventos com permissões específicas
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

    @PostMapping
    public Alocacao criar(@RequestBody Alocacao alocacao) {
        return service.salvar(alocacao);
    }

    @PutMapping("/{id}")
    public Alocacao atualizar(@PathVariable Long id, @RequestBody Alocacao alocacao) {
        return service.atualizar(id, alocacao);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
