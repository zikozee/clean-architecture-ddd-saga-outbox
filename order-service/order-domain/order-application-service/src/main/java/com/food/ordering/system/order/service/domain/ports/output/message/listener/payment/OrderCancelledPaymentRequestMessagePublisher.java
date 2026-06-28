package com.food.ordering.system.order.service.domain.ports.output.message.listener.payment;


import com.food.ordering.system.order.service.domain.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.order.service.domain.event.publisher.DomainEventPublisher;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
