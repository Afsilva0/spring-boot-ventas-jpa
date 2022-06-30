package com.playtech.ventas.miscellaneous.util;

import com.playtech.ventas.miscellaneous.dto.MessageExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;


@Component
public class ValidationMessage {

    @Autowired
    private MessageSource messagesExceptionSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messagesExceptionSource, Locale.getDefault());
    }

    public  MessageExceptionDTO loadMessage(ExceptionMessageEnum validation) {
        String code = accessor.getMessage(validation.getCode());
        String message = accessor.getMessage(validation.getMessage());
        String recom = accessor.getMessage(validation.getRecomen());

        MessageExceptionDTO messageExceptionDTO = MessageExceptionDTO
                .builder()
                .code(code)
                .message(message)
                .recomen(recom)
                .build();

        return messageExceptionDTO;
    }
    public MessageExceptionDTO loadMessage(ExceptionMessageEnum validation,String message) {
        String code = accessor.getMessage(validation.getCode());
        String recom = accessor.getMessage(validation.getRecomen());

        MessageExceptionDTO messageExceptionDTO = MessageExceptionDTO
                .builder()
                .code(code)
                .message(message)
                .recomen(recom)
                .build();

        return messageExceptionDTO;
    }
}
