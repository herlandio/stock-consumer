package com.herlandio7.stock_consumer.handler;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LowMessageHandler {

    public void handle(String message) {
        log.info("[LOW] Logging and monitoring for message: {}", message);
        logToMonitoringSystem(message);
    }

    public void logUnknownMessage(String level, String message) {
        log.warn("[UNKNOWN] Handling unknown level {} with message: {}", level, message);
        logToMonitoringSystem(String.format("Unknown level: %s, message: %s", level, message));
    }

    private void logToMonitoringSystem(String message) {
        log.info("Logging to monitoring system: {}", message);
        // TODO Lógica para registrar no sistema de monitoramento
    }
}

