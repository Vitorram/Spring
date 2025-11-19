package com.link.app.controller;

import com.link.app.model.Usuario;
import com.link.app.dto.UsuarioCadastroDTO;
import com.link.app.dto.UsuarioLoginDTO;
import com.link.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // Cadastrar novo usuário
    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioCadastroDTO dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()) != null) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(dto.getNomeCompleto());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setSenhaHash(passwordEncoder.encode(dto.getSenha())); // criptografando
        usuario.setStatus(dto.getStatus());
        usuario.setCpf(dto.getCpf());
        usuario.setPreferencias(dto.getPreferencias());
        usuario.setNascimento(LocalDate.parse(dto.getNascimento()));
        usuario.setGenero(dto.getGenero());
        usuario.setParceiro(dto.getParceiro());
        usuario.setCidade(dto.getCidade());

        Usuario salvo = usuarioRepository.save(usuario);
        return ResponseEntity.ok(salvo);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());

        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }

        if (passwordEncoder.matches(dto.getSenha(), usuario.getSenhaHash())) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(401).body("Senha incorreta");
        }
    }
}
