package com.playtech.ventas.bodega.repository;

import com.playtech.ventas.bodega.dto.BodegaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodegaRepository extends JpaRepository<BodegaDTO,Long> {
}
