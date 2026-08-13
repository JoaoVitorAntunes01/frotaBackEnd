package com.main.projeto_final.service;

import com.main.projeto_final.model.MotoristaDTO;
import com.main.projeto_final.model.RotasDTO;
import com.main.projeto_final.model.VeiculoDTO;
import com.main.projeto_final.repository.MotoristaRepository;
import com.main.projeto_final.repository.RotasRepository;
import com.main.projeto_final.repository.VeiculoRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class RotasService {
    
    @Autowired
    private RotasRepository rotasRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;
    
    public List<RotasDTO> findAll(){
        return rotasRepository.findAll();
    }

    public List<RotasDTO> findByEmpresaId(Long empresaId) {
        return rotasRepository.findByEmpresaId(empresaId);
    }

    public List<RotasDTO> findByMotoristaId(Long motoristaId) {
        return rotasRepository.findByMotoristaId(motoristaId);
    }

    public RotasDTO save(RotasDTO rota) {
        if (rota.getId_veiculo() == null || rota.getId_motorista() == null) {
            throw new IllegalArgumentException("id_veiculo e id_motorista são obrigatórios");
        }

        VeiculoDTO veiculo = veiculoRepository.findById(rota.getId_veiculo())
                .orElseThrow(() -> new NoSuchElementException(
                        "Veículo com id " + rota.getId_veiculo() + " não encontrado"));

        MotoristaDTO motorista = motoristaRepository.findById(rota.getId_motorista())
                .orElseThrow(() -> new NoSuchElementException(
                        "Motorista com id " + rota.getId_motorista() + " não encontrado"));

        if (!veiculo.getId_empresa().equals(motorista.getId_empresa())) {
            throw new IllegalArgumentException("O veículo e o motorista devem pertencer à mesma empresa");
        }

        rota.setVeiculo(veiculo);
        rota.setMotorista(motorista);
        return rotasRepository.save(rota);
    }
    
}
