package com.playtech.ventas.producto.service.impl;

import com.playtech.ventas.miscellaneous.dto.MessageExceptionDTO;
import com.playtech.ventas.miscellaneous.exeption.BusinessVentasExeption;
import com.playtech.ventas.miscellaneous.util.ExceptionMessageEnum;
import com.playtech.ventas.miscellaneous.util.ValidationMessage;
import com.playtech.ventas.producto.dto.ProductoDTO;
import com.playtech.ventas.producto.repository.ProductoRepository;
import com.playtech.ventas.producto.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {


    private ProductoRepository productoRepository;
    private ValidationMessage validationMessage;

    ProductoServiceImpl(ProductoRepository productoRepository, ValidationMessage validationMessage) {
        this.productoRepository = productoRepository;
        this.validationMessage = validationMessage;
    }

    @Override
    public ProductoDTO create(ProductoDTO productoDTO) {
        log.info("[{}] - Creación de producto  : Producto : {}", Thread.currentThread().getId(), productoDTO);
        try {
            return this.productoRepository.save(productoDTO);
        } catch (Exception e) {
            throw new BusinessVentasExeption((validationMessage.loadMessage(ExceptionMessageEnum.NO_EXISTE_BODEGA_PARA_EL_PRODUCTO).resolveMessage()));
        }

    }

    @Override
    public List<ProductoDTO> getAllProducto() {
        log.info("[{}] - Obtener todos los productos : Producto : {}", Thread.currentThread().getId());
        return this.productoRepository.findAll();
    }

    @Override
    public Optional<ProductoDTO> getProductoById(Long id) {
        log.info("[{}] - Obtener un producto : Producto : {}", Thread.currentThread().getId(), id);
        return this.productoRepository.findById(id);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("[{}] - Eliminar un producto : Producto : {}", Thread.currentThread().getId(), id);
        try {
            this.productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


}
