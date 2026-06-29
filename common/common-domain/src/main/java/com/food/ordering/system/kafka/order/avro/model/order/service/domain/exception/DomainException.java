package com.food.ordering.system.kafka.order.avro.model.order.service.domain.exception;


/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
