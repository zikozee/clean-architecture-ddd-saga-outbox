package com.food.ordering.system.payment.service.domain.exception;


import com.food.ordering.system.order.service.domain.exception.DomainException;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public class PaymentApplicationServiceException extends DomainException {

    public PaymentApplicationServiceException(String message) {
        super(message);
    }

    public PaymentApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
