package com.food.ordering.system.payment.service.domain.ports.input.messagelistener;


import com.food.ordering.system.payment.service.domain.dto.PaymentRequest;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public interface PaymentRequestMessageListener {

    void completePayment(PaymentRequest paymentRequest);
    void cancelPayment(PaymentRequest paymentRequest);
}
