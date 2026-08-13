package com.main.projeto_final.controller;

import com.main.projeto_final.model.EmpresaDTO;
import com.main.projeto_final.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8081")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    
    @GetMapping("/empresas")
    public List<EmpresaDTO> listempresas() {
        List<EmpresaDTO> empresas = empresaService.findAll();
        
        return empresas;
    }

    @PostMapping("/empresas")
    public EmpresaDTO cadastrarEmpresa(@RequestBody EmpresaDTO empresa) {
        return empresaService.save(empresa);
    }
    
}
