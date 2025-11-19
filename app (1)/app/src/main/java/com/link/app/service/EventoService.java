package com.link.app.service;

import com.link.app.model.Alocacao;
import com.link.app.model.Evento;
import com.link.app.model.Usuario;
import com.link.app.repository.AlocacaoRepository;
import com.link.app.repository.EventoRepository;
import com.link.app.repository.UsuarioRepository;
import com.link.app.dto.EventoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private AlocacaoRepository alocacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR TODOS COMO DTO
    public List<EventoDTO> listarTodosDTO() {
        return eventoRepository.findAll().stream().map(e -> {
            EventoDTO dto = new EventoDTO();
            dto.setId(e.getId());
            dto.setTitulo(e.getTitulo());
            dto.setDescricao(e.getDescricao());
            dto.setDataCriar(e.getDataCriar());
            dto.setDataInicio(e.getDataInicio());
            dto.setDataFim(e.getDataFim());
            dto.setCapacidade(e.getCapacidade());
            dto.setUsuarioId(e.getUsuario() != null ? e.getUsuario().getId() : null);
            dto.setNomeUsuario(e.getUsuario() != null ? e.getUsuario().getNomeCompleto() : null);
            dto.setAlocacaoId(e.getAlocacao() != null ? e.getAlocacao().getId() : null);
            return dto;
        }).toList();
    }

    // BUSCAR POR ID
    public EventoDTO buscarDTOPorId(Long id) {
        Evento e = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        EventoDTO dto = new EventoDTO();
        dto.setId(e.getId());
        dto.setTitulo(e.getTitulo());
        dto.setDescricao(e.getDescricao());
        dto.setDataCriar(e.getDataCriar());
        dto.setDataInicio(e.getDataInicio());
        dto.setDataFim(e.getDataFim());
        dto.setCapacidade(e.getCapacidade());
        dto.setUsuarioId(e.getUsuario() != null ? e.getUsuario().getId() : null);
        dto.setNomeUsuario(e.getUsuario() != null ? e.getUsuario().getNomeCompleto() : null);
        dto.setAlocacaoId(e.getAlocacao() != null ? e.getAlocacao().getId() : null);
        return dto;
    }

    // SALVAR NOVO
    public Evento salvar(Long usuarioId, Long alocacaoId, Evento evento) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Alocacao aloc = alocacaoRepository.findById(alocacaoId)
                .orElseThrow(() -> new RuntimeException("Alocação não encontrada"));

        evento.setUsuario(usuario);
        evento.setAlocacao(aloc);

        return eventoRepository.save(evento);
    }

    // ATUALIZAR
    public Evento atualizar(Long id, Long usuarioId, Long alocacaoId, Evento eventoAtualizado) {
        Evento existente = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        existente.setTitulo(eventoAtualizado.getTitulo());
        existente.setDescricao(eventoAtualizado.getDescricao());
        existente.setCapacidade(eventoAtualizado.getCapacidade());
        existente.setDataCriar(eventoAtualizado.getDataCriar());
        existente.setDataInicio(eventoAtualizado.getDataInicio());
        existente.setDataFim(eventoAtualizado.getDataFim());

        if (usuarioId != null) {
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            existente.setUsuario(usuario);
        }

        if (alocacaoId != null) {
            Alocacao aloc = alocacaoRepository.findById(alocacaoId)
                    .orElseThrow(() -> new RuntimeException("Alocação não encontrada"));
            existente.setAlocacao(aloc);
        }

        return eventoRepository.save(existente);
    }

    // DELETAR
    public void deletar(Long id) {
        eventoRepository.deleteById(id);
    }
}
