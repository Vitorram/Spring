package com.link.app.dto;

import com.link.app.model.Evento;

import java.time.LocalDate;

public class EventoDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataCriar;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer capacidade;
    private Long usuarioId;
    private String nomeUsuario;
    private Long alocacaoId;

    // GETTERS E SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataCriar() { return dataCriar; }
    public void setDataCriar(LocalDate dataCriar) { this.dataCriar = dataCriar; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public Long getAlocacaoId() { return alocacaoId; }
    public void setAlocacaoId(Long alocacaoId) { this.alocacaoId = alocacaoId; }

    // Método para converter DTO em Evento (entidade)
    public Evento toEvento() {
        Evento e = new Evento();
        e.setTitulo(this.titulo);
        e.setDescricao(this.descricao);
        e.setDataCriar(this.dataCriar);
        e.setDataInicio(this.dataInicio);
        e.setDataFim(this.dataFim);
        e.setCapacidade(this.capacidade);
        return e;
    }
}
