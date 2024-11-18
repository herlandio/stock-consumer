package com.herlandio7.stock_consumer.handler;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ModerateMessageHandler {

    public void handle(String message) {
        log.info("[MODERATE] Taking moderate action for message: {}", message);
        createTicket("Moderate Alert", message);
    }

    private void createTicket(String title, String description) {
        log.info("Creating ticket with title '{}' and description '{}'", title, description);
        // TODO Lógica de criação de ticket
    }
}
