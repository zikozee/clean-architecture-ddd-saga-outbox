package com.food.ordering.system.restaurant.service.domain.exception;


import com.food.ordering.system.order.service.domain.exception.DomainException;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Jul, 2026
 */

public class RestaurantDomainException extends DomainException {
    public RestaurantDomainException(String message) {
        super(message);
    }

    public RestaurantDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
