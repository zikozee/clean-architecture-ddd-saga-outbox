package com.food.ordering.system.restaurant.service.domain.ports.output.messagepublisher;


import com.food.ordering.system.order.service.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.restaurant.service.domain.event.OrderRejectedEvent;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Jul, 2026
 */

public interface OrderRejectedMessagePublisher extends DomainEventPublisher<OrderRejectedEvent> {
}
