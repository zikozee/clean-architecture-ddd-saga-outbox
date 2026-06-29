package com.food.ordering.system.kafka.producer.exception;


/**
 * @dev : Ezekiel Eromosei
 * @date : 29 Jun, 2026
 */

public class KafkaProducerException extends RuntimeException {

    public KafkaProducerException(String message) {
        super(message);
    }
}
