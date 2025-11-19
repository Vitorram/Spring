package com.link.app.dto;

import lombok.Data;

@Data
public class UsuarioCadastroDTO {
    private String nomeCompleto;
    private String email;
    private String telefone;
    private String senha; // senha em texto, vamos criptografar no controller
    private String status;
    private String cpf;
    private String preferencias;
    private String nascimento; // recebe como String do JSON
    private String genero;
    private Boolean parceiro;
    private Long cidade;
}
