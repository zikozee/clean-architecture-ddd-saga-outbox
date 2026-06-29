package com.food.ordering.system.kafka.order.avro.model.order.service.domain.exception;


/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public class OrderNotFoundException extends DomainException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}