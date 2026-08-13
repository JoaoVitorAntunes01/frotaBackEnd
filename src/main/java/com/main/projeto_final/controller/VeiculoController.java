package com.main.projeto_final.controller;

import com.main.projeto_final.model.VeiculoDTO;
import com.main.projeto_final.service.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8081")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;
    
    @GetMapping("/veiculos")
    public List<VeiculoDTO> listveiculos(@RequestParam(required = false) Long id_empresa) {
        if (id_empresa != null) {
            return veiculoService.findByEmpresaId(id_empresa);
        }
        return veiculoService.findAll();
    }

    @PostMapping("/veiculos")
    public VeiculoDTO cadastrarVeiculo(@RequestBody VeiculoDTO veiculo) {
        return veiculoService.save(veiculo);
    }
    
}
