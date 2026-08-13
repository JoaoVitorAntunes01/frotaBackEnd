package com.main.projeto_final.controller;

import com.main.projeto_final.model.RotasDTO;
import com.main.projeto_final.service.RotasService;
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
public class RotasController {
    @Autowired
    private RotasService rotasService;
    
    @GetMapping("/rotas")
    public List<RotasDTO> listrotas(@RequestParam(required = false) Long id_empresa,
                                     @RequestParam(required = false) Long id_motorista) {
        if (id_empresa != null) {
            return rotasService.findByEmpresaId(id_empresa);
        }
        if (id_motorista != null) {
            return rotasService.findByMotoristaId(id_motorista);
        }
        return rotasService.findAll();
    }

    @PostMapping("/rotas")
    public RotasDTO cadastrarRota(@RequestBody RotasDTO rota) {
        return rotasService.save(rota);
    }
    
}
