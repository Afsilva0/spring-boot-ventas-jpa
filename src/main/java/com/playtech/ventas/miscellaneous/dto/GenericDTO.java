package com.playtech.ventas.miscellaneous.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericDTO {

    private Integer status;
    private Object payload;

}
