package com.playtech.ventas.producto.dto;

import com.playtech.ventas.bodega.dto.BodegaDTO;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class ProductoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nombre;

    private String descripcion;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idBodega")
    private BodegaDTO bodega;
}
