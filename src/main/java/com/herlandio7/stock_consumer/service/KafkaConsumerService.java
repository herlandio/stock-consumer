package com.herlandio7.stock_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerService {
    
    @KafkaListener(topics = "low-stock-notifications", groupId = "notification-consumer-group")
    public void consume(String message) {
        try {
            log.warn("Consumed message: {}", message);
        } catch (Exception e) {
            log.error("Error processing message: {}", e.getMessage());
        }
    }

}
