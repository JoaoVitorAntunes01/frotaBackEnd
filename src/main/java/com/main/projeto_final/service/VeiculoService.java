/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.projeto_final.service;

import com.main.projeto_final.model.VeiculoDTO;
import com.main.projeto_final.repository.VeiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;
    
    public List<VeiculoDTO> findAll(){
        return veiculoRepository.findAll();
    }
    
}
