package com.playtech.ventas.empresa.controller;

import com.playtech.ventas.empresa.dto.EmpresaDTO;
import com.playtech.ventas.empresa.service.EmpresaService;
import com.playtech.ventas.miscellaneous.dto.GenericDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("prueba")
    String prueba() {
        return "Prueba Empresa";
    }

    @GetMapping("getAll")
    ResponseEntity<GenericDTO> getAll() {
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.empresaService.getAll());

        return ResponseEntity.ok().body(genericDTO);
    }

    @PostMapping("create")
    ResponseEntity<GenericDTO> create(@RequestBody EmpresaDTO empresaDTO) {
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.empresaService.create(empresaDTO));

        return ResponseEntity.ok().body(genericDTO);

    }

    @GetMapping("getById/{id}")
    ResponseEntity<GenericDTO> getById(@PathVariable Long id) {
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.empresaService.getById(id));

        return ResponseEntity.ok().body(genericDTO);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<GenericDTO> delete(@PathVariable Long id) {
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.empresaService.delete(id));

        return ResponseEntity.ok().body(genericDTO);
    }

}
