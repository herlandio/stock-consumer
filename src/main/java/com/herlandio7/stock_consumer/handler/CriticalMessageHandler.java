package com.herlandio7.stock_consumer.handler;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriticalMessageHandler {

    public void handle(String message) {
        log.info("[CRITICAL] Urgent handling for message: {}", message);
        sendEmail("admin@example.com", "Critical Alert", message);
    }

    private void sendEmail(String to, String subject, String body) {
        log.info("Sending email to {} with subject '{}'", to, subject);
        // TODO Lógica de envio de email
    }
}
