package com.food.ordering.system.order.service.domain.ports.output.message.listener.restaurantapproval;


import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.food.ordering.system.order.service.domain.event.publisher.DomainEventPublisher;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface OrderPaidRestaurantMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
