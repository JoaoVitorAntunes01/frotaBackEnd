package com.main.projeto_final.repository;

import com.main.projeto_final.model.VeiculoDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoDTO, Long>{

    @Query("SELECT v FROM VeiculoDTO v WHERE v.empresa.id = :empresaId")
    List<VeiculoDTO> findByEmpresaId(@Param("empresaId") Long empresaId);
}
