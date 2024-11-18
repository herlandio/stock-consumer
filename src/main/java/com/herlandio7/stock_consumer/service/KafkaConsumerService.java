package com.herlandio7.stock_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.herlandio7.stock_consumer.handler.CriticalMessageHandler;
import com.herlandio7.stock_consumer.handler.LowMessageHandler;
import com.herlandio7.stock_consumer.handler.ModerateMessageHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final CriticalMessageHandler criticalMessageHandler;
    private final ModerateMessageHandler moderateMessageHandler;
    private final LowMessageHandler lowMessageHandler;

    @KafkaListener(topics = "critical-stock-notifications", groupId = "notification-consumer-group")
    public void consumeCritical(String message) {
        processMessage("CRITICAL", message);
    }

    @KafkaListener(topics = "moderate-stock-notifications", groupId = "notification-consumer-group")
    public void consumeModerate(String message) {
        processMessage("MODERATE", message);
    }

    @KafkaListener(topics = "low-stock-notifications", groupId = "notification-consumer-group")
    public void consumeLow(String message) {
        processMessage("LOW", message);
    }

    private void processMessage(String level, String message) {
        try {
            log.info("[{}] Consumed message: {}", level, message);
            switch (level.toUpperCase()) {
                case "CRITICAL":
                    criticalMessageHandler.handle(message);
                    break;
                case "MODERATE":
                    moderateMessageHandler.handle(message);
                    break;
                case "LOW":
                    lowMessageHandler.handle(message);
                    break;
                default:
                    log.warn("[{}] Unknown level, default handling applied: {}", level, message);
                    //TODO Registrar mensagem desconhecida no sistema de monitoramento
                    lowMessageHandler.logUnknownMessage(level, message);
            }
        } catch (Exception e) {
            log.error("[{}] Error processing message: {}", level, e.getMessage());
        }
    }
}

