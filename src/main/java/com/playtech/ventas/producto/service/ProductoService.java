package com.playtech.ventas.producto.service;

import com.playtech.ventas.producto.dto.ProductoDTO;

import java.util.List;
import java.util.Optional;


public interface ProductoService {

    List<ProductoDTO> getAllProducto();

    ProductoDTO create(ProductoDTO productoDTO);

    Optional<ProductoDTO> getProductoById(Long id);

    Boolean delete(Long id);
}
