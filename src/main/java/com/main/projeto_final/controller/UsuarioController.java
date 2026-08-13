package com.main.projeto_final.controller;

import com.main.projeto_final.model.EmpresaDTO;
import com.main.projeto_final.model.LoginRequestDTO;
import com.main.projeto_final.model.LoginResponseDTO;
import com.main.projeto_final.model.MotoristaDTO;
import com.main.projeto_final.model.UsuarioDTO;
import com.main.projeto_final.repository.EmpresaRepository;
import com.main.projeto_final.repository.MotoristaRepository;
import com.main.projeto_final.repository.UsuarioRepository;
import com.main.projeto_final.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;
    
    @GetMapping("/usuarios")
    public List<UsuarioDTO> listusuario() {
        List<UsuarioDTO> usuario = usuarioService.findAll();
        
        return usuario;
    }
    
    @PostMapping("/logar")
    public ResponseEntity<?> logarusuario(@RequestBody LoginRequestDTO request) {
        Optional<UsuarioDTO> usuarioOpt = usuarioRepository.findByEmailAndSenha(request.getEmail(), request.getSenha());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha inválidos");
        }

        UsuarioDTO usuario = usuarioOpt.get();
        String tipo = request.getTipo() != null ? request.getTipo().toUpperCase() : "";

        if ("EMPRESA".equals(tipo)) {
            Optional<EmpresaDTO> empresaOpt = empresaRepository.findByUsuarioId(usuario.getId());
            if (empresaOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Este usuário não está cadastrado como empresa");
            }
            return ResponseEntity.ok(montarResposta(usuario, "EMPRESA", empresaOpt.get().getId()));
        }

        if ("MOTORISTA".equals(tipo)) {
            Optional<MotoristaDTO> motoristaOpt = motoristaRepository.findByUsuarioId(usuario.getId());
            if (motoristaOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Este usuário não está cadastrado como motorista");
            }
            return ResponseEntity.ok(montarResposta(usuario, "MOTORISTA", motoristaOpt.get().getId()));
        }

        return ResponseEntity.badRequest().body("Tipo de login inválido");
    }

    private LoginResponseDTO montarResposta(UsuarioDTO usuario, String tipo, Long idPerfil) {
        LoginResponseDTO response = new LoginResponseDTO();
        response.setIdUsuario(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setTipo(tipo);
        response.setIdPerfil(idPerfil);
        return response;
    }
    
    @PostMapping("/cadastrar")
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO request){
        return usuarioRepository.save(request);
    }
}
