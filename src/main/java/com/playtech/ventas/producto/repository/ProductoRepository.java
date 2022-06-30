package com.playtech.ventas.producto.repository;


import com.playtech.ventas.producto.dto.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<ProductoDTO,Long> {
}
