package com.playtech.ventas.bodega.dto;

import com.playtech.ventas.empresa.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bodegas")
public class BodegaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private EmpresaDTO empresa;
}

