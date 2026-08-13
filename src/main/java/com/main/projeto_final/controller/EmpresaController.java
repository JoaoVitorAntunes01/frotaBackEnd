/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.projeto_final.controller;

import com.main.projeto_final.model.EmpresaDTO;
import com.main.projeto_final.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    
    @GetMapping("/empresas")
    public List<EmpresaDTO> listempresas() {
        List<EmpresaDTO> empresas = empresaService.findAll();
        
        return empresas;
    }
    
}
