/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.projeto_final.controller;

import com.main.projeto_final.model.VeiculoDTO;
import com.main.projeto_final.service.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;
    
    @GetMapping("/veiculos")
    public List<VeiculoDTO> listveiculos() {
        List<VeiculoDTO> veiculo = veiculoService.findAll();
        
        return veiculo;
    }
    
}
