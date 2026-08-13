package com.main.projeto_final.service;

import com.main.projeto_final.model.EmpresaDTO;
import com.main.projeto_final.model.UsuarioDTO;
import com.main.projeto_final.repository.EmpresaRepository;
import com.main.projeto_final.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<EmpresaDTO> findAll(){
        return empresaRepository.findAll();
    }

    public EmpresaDTO save(EmpresaDTO empresa) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome(empresa.getNome());
        usuario.setEmail(empresa.getEmail());
        usuario.setSenha(empresa.getSenha());
        UsuarioDTO usuarioSalvo = usuarioRepository.save(usuario);

        empresa.setUsuario(usuarioSalvo);
        return empresaRepository.save(empresa);
    }
    
}
