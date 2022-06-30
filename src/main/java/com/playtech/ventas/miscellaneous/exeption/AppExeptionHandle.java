package com.playtech.ventas.miscellaneous.exeption;

import com.playtech.ventas.miscellaneous.dto.GenericDTO;
import com.playtech.ventas.miscellaneous.dto.MessageExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AppExeptionHandle {

    @ResponseBody
    @ExceptionHandler(BusinessVentasExeption.class)
    ResponseEntity<GenericDTO> handleException(BusinessVentasExeption exeption){
        log.info("[{}] Exception BusinessVentasExeption, mensaje: {}", Thread.currentThread().getId(), exeption.getMessage());

        MessageExceptionDTO messageExceptionDTO= MessageExceptionDTO.builder().build();
        messageExceptionDTO.setData(exeption.getMessage());

        GenericDTO genericDTO= new GenericDTO();
        genericDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        genericDTO.setPayload(messageExceptionDTO);

        return ResponseEntity.ok().body(genericDTO);
    }

}
