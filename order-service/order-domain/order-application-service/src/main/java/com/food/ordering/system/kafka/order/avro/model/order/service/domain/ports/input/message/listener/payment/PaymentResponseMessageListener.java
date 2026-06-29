package com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.input.message.listener.payment;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.message.PaymentResponse;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
