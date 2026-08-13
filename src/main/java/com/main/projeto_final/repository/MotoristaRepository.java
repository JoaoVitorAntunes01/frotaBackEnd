package com.main.projeto_final.repository;

import com.main.projeto_final.model.MotoristaDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<MotoristaDTO, Long>{

    @Query("SELECT m FROM MotoristaDTO m WHERE m.id_usuario.id = :usuarioId")
    Optional<MotoristaDTO> findByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT m FROM MotoristaDTO m WHERE m.empresa.id = :empresaId")
    List<MotoristaDTO> findByEmpresaId(@Param("empresaId") Long empresaId);
}
