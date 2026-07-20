package com.food.ordering.system.payment.service.domain.event;


import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public class PaymentCancelledEvent extends PaymentEvent{

    public PaymentCancelledEvent(Payment payment, ZonedDateTime createAt) {
        super(payment, createAt, Collections.emptyList());
    }
}
