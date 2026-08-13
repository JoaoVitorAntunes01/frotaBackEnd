package com.main.projeto_final.service;

import com.main.projeto_final.model.MotoristaDTO;
import com.main.projeto_final.model.UsuarioDTO;
import com.main.projeto_final.repository.MotoristaRepository;
import com.main.projeto_final.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<MotoristaDTO> findAll() {
        return motoristaRepository.findAll();
    }

    public MotoristaDTO save(MotoristaDTO motorista) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome(motorista.getNome());
        usuario.setEmail(motorista.getEmail());
        usuario.setSenha(motorista.getSenha());
        UsuarioDTO usuarioSalvo = usuarioRepository.save(usuario);

        motorista.setId_usuario(usuarioSalvo);
        return motoristaRepository.save(motorista);
    }
}
