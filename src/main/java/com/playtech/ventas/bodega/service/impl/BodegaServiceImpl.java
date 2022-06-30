package com.playtech.ventas.bodega.service.impl;

import com.playtech.ventas.bodega.dto.BodegaDTO;
import com.playtech.ventas.bodega.repository.BodegaRepository;
import com.playtech.ventas.bodega.service.BodegaService;
import com.playtech.ventas.miscellaneous.exeption.BusinessVentasExeption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BodegaServiceImpl implements BodegaService {


    private final BodegaRepository bodegaRepository;

    public BodegaServiceImpl(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    @Override
    public List<BodegaDTO> getAll() {
        log.info("[{}] - Obtener todas las bodegas : Bodega : {}", Thread.currentThread().getId());
        return this.bodegaRepository.findAll();
    }

    @Override
    public BodegaDTO create(BodegaDTO bodegaDTO) {
        log.info("[{}] - Creación de bodega : Bodega : {}", Thread.currentThread().getId(), bodegaDTO);
        try {
            return this.bodegaRepository.save(bodegaDTO);
        } catch (Exception e) {
            throw new BusinessVentasExeption(e.getMessage());
        }
    }

    @Override
    public Optional<BodegaDTO> getById(Long id) {
        log.info("[{}] - Obtener una bodega : Bodega : {}", Thread.currentThread().getId(), id);
        return this.bodegaRepository.findById(id);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("[{}] - Eliminar una bodega : Bodega : {}", Thread.currentThread().getId(), id);
        try {
            this.bodegaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
