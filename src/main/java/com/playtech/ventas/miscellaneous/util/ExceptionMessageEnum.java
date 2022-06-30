package com.playtech.ventas.miscellaneous.util;

import com.sun.istack.NotNull;

public enum ExceptionMessageEnum {

    UNKNOWN_EXCEPTION("UnknownException.code", "UnknownException.message", "UnknownException.recomen"),
    NO_EXISTE_BODEGA_PARA_EL_PRODUCTO("NoExisteBodegaParaProducto.code", "NoExisteBodegaParaProducto.message", "NoExisteBodegaParaProducto.recomen");

    private final String code;
    private final String message;
    private final String recomen;

    private ExceptionMessageEnum(String code, String message, String recomen) {
        this.code = code;
        this.message = message;
        this.recomen = recomen;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRecomen() {
        return recomen;
    }
}
