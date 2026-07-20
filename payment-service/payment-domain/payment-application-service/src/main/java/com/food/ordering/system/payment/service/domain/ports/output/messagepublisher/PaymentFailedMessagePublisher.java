package com.food.ordering.system.payment.service.domain.ports.output.messagepublisher;


import com.food.ordering.system.order.service.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.payment.service.domain.event.PaymentFailedEvent;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public interface PaymentFailedMessagePublisher extends DomainEventPublisher<PaymentFailedEvent> {
}
