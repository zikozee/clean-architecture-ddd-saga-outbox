package com.food.ordering.system.payment.service.domain.event;


import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public class PaymentFailedEvent extends PaymentEvent{

    public PaymentFailedEvent(Payment payment, ZonedDateTime createAt, List<String> failureMessages) {
        super(payment, createAt, failureMessages);
    }
}
