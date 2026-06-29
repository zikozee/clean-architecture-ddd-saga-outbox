package com.food.ordering.system.kafka.order.avro.model.order.service.domain.exception;


/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

public class OrderDomainException extends  DomainException{

    public OrderDomainException(String message) {
        super(message);
    }

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
