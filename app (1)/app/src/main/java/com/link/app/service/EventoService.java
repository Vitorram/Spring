package com.link.app.service;

import com.link.app.model.Alocacao;
import com.link.app.model.Evento;
import com.link.app.repository.AlocacaoRepository;
import com.link.app.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private AlocacaoRepository alocacaoRepository;

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    public Evento salvar(Evento evento) {
        Long idAloc = evento.getAlocacao().getId();

        Alocacao aloc = alocacaoRepository.findById(idAloc)
                .orElseThrow(() -> new RuntimeException("Alocação não encontrada"));

        evento.setAlocacao(aloc);

        return eventoRepository.save(evento);
    }

    public Evento atualizar(Long id, Evento eventoAtualizado) {

        Evento existente = buscarPorId(id);

        existente.setTitulo(eventoAtualizado.getTitulo());
        existente.setDescricao(eventoAtualizado.getDescricao());
        existente.setCapacidade(eventoAtualizado.getCapacidade());
        existente.setDataCriar(eventoAtualizado.getDataCriar());
        existente.setDataInicio(eventoAtualizado.getDataInicio());
        existente.setDataFim(eventoAtualizado.getDataFim());
        existente.setIdUsuario(eventoAtualizado.getIdUsuario());

        Long idAloc = eventoAtualizado.getAlocacao().getId();

        Alocacao aloc = alocacaoRepository.findById(idAloc)
                .orElseThrow(() -> new RuntimeException("Alocação não encontrada"));

        existente.setAlocacao(aloc);

        return eventoRepository.save(existente);
    }

    public void deletar(Long id) {
        eventoRepository.deleteById(id);
    }
}
