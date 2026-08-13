/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.projeto_final.controller;

import com.main.projeto_final.model.UsuarioDTO;
import com.main.projeto_final.repository.UsuarioRepository;
import com.main.projeto_final.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/usuarios")
    public List<UsuarioDTO> listusuario() {
        List<UsuarioDTO> usuario = usuarioService.findAll();
        
        return usuario;
    }
    
    @PostMapping("/logar")
    public UsuarioDTO logarusuario(@RequestBody UsuarioDTO request){
        Optional<UsuarioDTO> usuariologado = usuarioRepository.findByEmailAndSenha(request.getEmail(), request.getSenha());
        if(usuariologado.isPresent()){
            return usuariologado.get();
        }
        
        return request;
    }
    
    @PostMapping("/cadastrar")
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO request){
        return usuarioRepository.save(request);
    }
}
