package com.main.projeto_final.repository;

import com.main.projeto_final.model.RotasDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RotasRepository extends JpaRepository<RotasDTO, Long>{

    @Query("SELECT r FROM RotasDTO r WHERE r.motorista.empresa.id = :empresaId ORDER BY r.hora_saida DESC")
    List<RotasDTO> findByEmpresaId(@Param("empresaId") Long empresaId);

    @Query("SELECT r FROM RotasDTO r WHERE r.motorista.id = :motoristaId ORDER BY r.hora_saida DESC")
    List<RotasDTO> findByMotoristaId(@Param("motoristaId") Long motoristaId);
}
