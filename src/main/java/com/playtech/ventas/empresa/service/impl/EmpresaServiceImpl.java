package com.playtech.ventas.empresa.service.impl;

import com.playtech.ventas.empresa.dto.EmpresaDTO;
import com.playtech.ventas.empresa.repository.EmpresaRepository;
import com.playtech.ventas.empresa.service.EmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<EmpresaDTO> getAll() {
        log.info("[{}] - Obtener todas las empresa : Empresa : {}", Thread.currentThread().getId());
        return this.empresaRepository.findAll();
    }

    @Override
    public EmpresaDTO create(EmpresaDTO empresaDTO) {
        log.info("[{}] - Creación de empresa : Empresa : {}", Thread.currentThread().getId(), empresaDTO);
        return this.empresaRepository.save(empresaDTO);
    }

    @Override
    public Optional<EmpresaDTO> getById(Long id) {
        log.info("[{}] - Obtener una empresa : Empresa : {}", Thread.currentThread().getId(), id);
        return this.empresaRepository.findById(id);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("[{}] - Eliminar una empresa : Empresa : {}", Thread.currentThread().getId(), id);
        try {
            this.empresaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
