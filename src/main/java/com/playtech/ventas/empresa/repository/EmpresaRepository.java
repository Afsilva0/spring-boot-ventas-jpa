package com.playtech.ventas.empresa.repository;

import com.playtech.ventas.empresa.dto.EmpresaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaDTO,Long> {
}
