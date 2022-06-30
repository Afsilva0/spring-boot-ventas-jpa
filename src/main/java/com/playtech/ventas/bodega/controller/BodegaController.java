package com.playtech.ventas.bodega.controller;


import com.playtech.ventas.bodega.dto.BodegaDTO;
import com.playtech.ventas.bodega.service.BodegaService;
import com.playtech.ventas.miscellaneous.dto.GenericDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bodega")
public class BodegaController {


    private final BodegaService bodegaService;

    @Autowired
    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }


    @GetMapping("prueba")
    String prueba() {
        return "Prueba Bodega";
    }


    @GetMapping("getAll")
    ResponseEntity<GenericDTO> getAll() {
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.bodegaService.getAll());

        return ResponseEntity.ok().body(genericDTO);
    }

    @PostMapping("create")
    ResponseEntity<GenericDTO> create(@RequestBody BodegaDTO bodegaDTO) {
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setPayload(HttpStatus.OK.value());
        genericDTO.setPayload(this.bodegaService.create(bodegaDTO));

        return ResponseEntity.ok().body(genericDTO);
    }

    @GetMapping("getById/{id}")
    ResponseEntity<GenericDTO> getById(@PathVariable Long id) {
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.bodegaService.getById(id));

        return ResponseEntity.ok().body(genericDTO);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<GenericDTO> delete(@PathVariable Long id){
        GenericDTO genericDTO= new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.bodegaService.delete(id));

        return ResponseEntity.ok().body(genericDTO);
    }

}
