package com.main.projeto_final.controller;

import com.main.projeto_final.model.MotoristaDTO;
import com.main.projeto_final.service.MotoristaService;
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
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping("/motoristas")
    public List<MotoristaDTO> listmotoristas() {
        return motoristaService.findAll();
    }

    @PostMapping("/motoristas")
    public MotoristaDTO cadastrarMotorista(@RequestBody MotoristaDTO motorista) {
        return motoristaService.save(motorista);
    }
}
