package com.link.app.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String email;
    private String telefone;
    private String senhaHash; // senha criptografada
    private String status; // ATIVO, INATIVO etc.
    private String cpf;
    private String preferencias;
    private LocalDate nascimento;
    private String genero;
    private Boolean parceiro; // 0 = false, 1 = true
    private Long cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Evento> eventos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Alocacao> alocacoes;
}
