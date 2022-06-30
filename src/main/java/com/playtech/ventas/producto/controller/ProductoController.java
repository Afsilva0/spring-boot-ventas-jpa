package com.playtech.ventas.producto.controller;

import com.playtech.ventas.miscellaneous.dto.GenericDTO;
import com.playtech.ventas.producto.dto.ProductoDTO;
import com.playtech.ventas.producto.service.ProductoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("producto")
public class ProductoController {


    private final ProductoService productoService;

    @Autowired
    ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping("prueba")
    ResponseEntity<String> prueba() {
        return ResponseEntity.ok().body("Prueba");
    }

    @PostMapping("create")
    ResponseEntity<GenericDTO> create(@RequestBody ProductoDTO productoDTO) {

        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.productoService.create(productoDTO));

        return ResponseEntity.ok().body(genericDTO);
    }

    @GetMapping("getAll")
    ResponseEntity<GenericDTO> getAll() {

        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.productoService.getAllProducto());

        return ResponseEntity.ok().body(genericDTO);
    }

    @GetMapping("getById/{id}")
    ResponseEntity<GenericDTO> getById(@PathVariable Long id) {

        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.productoService.getProductoById(id));

        return ResponseEntity.ok().body(genericDTO);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<GenericDTO> delete(@PathVariable Long id) {

        GenericDTO genericDTO= new GenericDTO();
        genericDTO.setStatus(HttpStatus.OK.value());
        genericDTO.setPayload(this.productoService.delete(id));
        return ResponseEntity.ok().body(genericDTO);
    }

}
