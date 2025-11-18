package com.link.app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario;

    private LocalDate dataCriar;

    private String titulo;
    private String descricao;

    private Integer capacidade;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    // CORREÇÃO AQUI
    @ManyToOne
    @JoinColumn(name = "alocacao_id")
    private Alocacao alocacao;
}
