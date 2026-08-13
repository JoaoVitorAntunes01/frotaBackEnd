/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.projeto_final.service;

import com.main.projeto_final.model.RotasDTO;
import com.main.projeto_final.repository.RotasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class RotasService {
    
    @Autowired
    private RotasRepository rotasRepository;
    
    public List<RotasDTO> findAll(){
        return rotasRepository.findAll();
    }
    
}

