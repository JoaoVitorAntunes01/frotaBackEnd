package com.main.projeto_final.repository;

import com.main.projeto_final.model.EmpresaDTO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaDTO, Long>{

    @Query("SELECT e FROM EmpresaDTO e WHERE e.usuario.id = :usuarioId")
    Optional<EmpresaDTO> findByUsuarioId(@Param("usuarioId") Long usuarioId);
}
