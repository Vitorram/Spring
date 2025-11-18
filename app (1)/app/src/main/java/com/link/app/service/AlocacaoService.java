package com.link.app.service;

import com.link.app.model.Alocacao;
import com.link.app.repository.AlocacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlocacaoService {

    private final AlocacaoRepository repository;

    public AlocacaoService(AlocacaoRepository repository) {
        this.repository = repository;
    }

    public List<Alocacao> listar() {
        return repository.findAll();
    }

    public Alocacao buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Alocacao salvar(Alocacao alocacao) {
        return repository.save(alocacao);
    }

    public Alocacao atualizar(Long id, Alocacao nova) {
        return repository.findById(id)
                .map(a -> {
                    a.setLatitude(nova.getLatitude());
                    a.setLongitude(nova.getLongitude());
                    a.setNome(nova.getNome());
                    a.setDescricao(nova.getDescricao());
                    a.setLotacao(nova.getLotacao());
                    a.setDocumentacao(nova.getDocumentacao());
                    a.setFachada(nova.getFachada());
                    return repository.save(a);
                })
                .orElse(null);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
