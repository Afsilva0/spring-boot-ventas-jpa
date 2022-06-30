package com.playtech.ventas.bodega.service;

import com.playtech.ventas.bodega.dto.BodegaDTO;

import java.util.List;
import java.util.Optional;

public interface BodegaService {

   List<BodegaDTO> getAll();

   BodegaDTO create(BodegaDTO bodegaDTO);

   Optional<BodegaDTO> getById(Long id);

   Boolean delete(Long id);

}
