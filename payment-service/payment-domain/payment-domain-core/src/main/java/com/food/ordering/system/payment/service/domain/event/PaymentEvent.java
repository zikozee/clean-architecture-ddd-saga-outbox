package com.food.ordering.system.payment.service.domain.event;


import com.food.ordering.system.order.service.domain.event.DomainEvent;
import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public abstract class PaymentEvent implements DomainEvent<Payment> {

    private final Payment payment;
    private final ZonedDateTime createAt;
    private List<String> failureMessages;

    protected PaymentEvent(Payment payment, ZonedDateTime createAt, List<String> failureMessages) {
        this.payment = payment;
        this.createAt = createAt;
        this.failureMessages = failureMessages;
    }

    public Payment getPayment() {
        return payment;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
}
