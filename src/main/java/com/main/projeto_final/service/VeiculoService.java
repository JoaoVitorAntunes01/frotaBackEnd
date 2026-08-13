package com.main.projeto_final.service;

import com.main.projeto_final.model.EmpresaDTO;
import com.main.projeto_final.model.VeiculoDTO;
import com.main.projeto_final.repository.EmpresaRepository;
import com.main.projeto_final.repository.VeiculoRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;
    
    public List<VeiculoDTO> findAll(){
        return veiculoRepository.findAll();
    }

    public List<VeiculoDTO> findByEmpresaId(Long empresaId) {
        return veiculoRepository.findByEmpresaId(empresaId);
    }

    public VeiculoDTO save(VeiculoDTO veiculo) {
        EmpresaDTO empresa = empresaRepository.findById(veiculo.getId_empresa())
                .orElseThrow(() -> new NoSuchElementException(
                        "Empresa com id " + veiculo.getId_empresa() + " não encontrada"));
        veiculo.setEmpresa(empresa);
        return veiculoRepository.save(veiculo);
    }
    
}
