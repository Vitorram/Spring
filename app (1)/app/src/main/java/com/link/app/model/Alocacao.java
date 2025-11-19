package com.link.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Alocacao {
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

    private String nome;
    private String descricao;

    private int lotacao;

    private String documentacao;
    private String fachada;
}
