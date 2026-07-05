package com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment;


import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.event.publisher.DomainEventPublisher;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
