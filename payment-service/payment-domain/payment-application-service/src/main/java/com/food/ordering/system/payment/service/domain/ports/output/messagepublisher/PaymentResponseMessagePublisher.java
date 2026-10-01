package com.food.ordering.system.payment.service.domain.ports.output.messagepublisher;


import com.food.ordering.system.outbox.OutboxStatus;
import com.food.ordering.system.payment.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Sep, 2026
 */

public interface PaymentResponseMessagePublisher {
    void publish(OrderOutboxMessage orderOutboxMessage, BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);
}
