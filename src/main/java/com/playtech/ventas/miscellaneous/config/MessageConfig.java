package com.playtech.ventas.miscellaneous.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
@Slf4j
public class MessageConfig {

    @Bean
    public MessageSource messagesExceptionSource() {
        log.info("[{}] messagesExceptionSource cargando ", Thread.currentThread().getId());
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages/exception/message_es_CO");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(Locale.getDefault());
        System.out.println(messageSource);
        return messageSource;
    }
}