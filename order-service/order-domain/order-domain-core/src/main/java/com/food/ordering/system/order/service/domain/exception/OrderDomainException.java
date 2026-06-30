package com.food.ordering.system.order.service.domain.exception;


import com.food.ordering.system.order.service.domain.exception.DomainException;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

public class OrderDomainException extends DomainException {

    public OrderDomainException(String message) {
        super(message);
    }

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
