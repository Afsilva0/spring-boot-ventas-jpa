package com.playtech.ventas.miscellaneous.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.Map;

@Data
@Builder
@Slf4j
public class MessageExceptionDTO {
    @Builder.Default
    private String code = "LC00";

    @Builder.Default
    private String message = "Error no identificado.";

    @Builder.Default
    private String recomen = "Comuniquese con el administrador";


    public MessageExceptionDTO(String code,String message,String recomen) {
        this.code= code;
        this.message = message;
        this.recomen = recomen;
    }


    public void setData(String dataJson) {
        ObjectMapper mapper = new ObjectMapper();
        try {

            // convert JSON string to Map
            Map<String, String> map = mapper.readValue(dataJson, Map.class);

            this.code = map.get("code");
            this.message = map.get("message");
            this.recomen = map.get("recomen");

        } catch (IOException e) {
            log.error("[{}] Error generando mapa a partir de json para String: {}, message:{}",
                    Thread.currentThread().getId(), dataJson, e.getMessage());
        }
    }

    public String resolveMessage() {

        ObjectMapper obj = new ObjectMapper();
        String jsonStr = null;

        try {
            jsonStr = obj.writeValueAsString(this);
        } catch (IOException exception) {
            log.error("[{}] Error obteniendo JSON(resolveMessage(ValidationMessage)): dto:{}, message: {} ", Thread.currentThread().getId(), exception);
        }

        return jsonStr;
    }

}
