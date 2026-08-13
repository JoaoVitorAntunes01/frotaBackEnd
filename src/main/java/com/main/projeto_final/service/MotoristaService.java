package com.main.projeto_final.service;

import com.main.projeto_final.model.EmpresaDTO;
import com.main.projeto_final.model.MotoristaDTO;
import com.main.projeto_final.model.UsuarioDTO;
import com.main.projeto_final.repository.EmpresaRepository;
import com.main.projeto_final.repository.MotoristaRepository;
import com.main.projeto_final.repository.UsuarioRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<MotoristaDTO> findAll() {
        return motoristaRepository.findAll();
    }

    public List<MotoristaDTO> findByEmpresaId(Long empresaId) {
        return motoristaRepository.findByEmpresaId(empresaId);
    }

    public MotoristaDTO save(MotoristaDTO motorista) {
        if (motorista.getId_empresa() == null) {
            throw new IllegalArgumentException("id_empresa é obrigatório para cadastrar um motorista");
        }

        EmpresaDTO empresa = empresaRepository.findById(motorista.getId_empresa())
                .orElseThrow(() -> new NoSuchElementException(
                        "Empresa com id " + motorista.getId_empresa() + " não encontrada"));

        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome(motorista.getNome());
        usuario.setEmail(motorista.getEmail());
        usuario.setSenha(motorista.getSenha());
        UsuarioDTO usuarioSalvo = usuarioRepository.save(usuario);

        motorista.setId_usuario(usuarioSalvo);
        motorista.setEmpresa(empresa);
        return motoristaRepository.save(motorista);
    }
}
