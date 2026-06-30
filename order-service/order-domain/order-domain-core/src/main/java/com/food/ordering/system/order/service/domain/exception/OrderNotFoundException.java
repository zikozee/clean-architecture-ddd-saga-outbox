package com.food.ordering.system.order.service.domain.exception;


import com.food.ordering.system.order.service.domain.exception.DomainException;

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