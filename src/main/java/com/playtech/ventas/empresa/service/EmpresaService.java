package com.playtech.ventas.empresa.service;

import com.playtech.ventas.empresa.dto.EmpresaDTO;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    List<EmpresaDTO> getAll();

    EmpresaDTO create(EmpresaDTO empresa);

    Optional<EmpresaDTO> getById(Long id);

    Boolean delete(Long id);
}
