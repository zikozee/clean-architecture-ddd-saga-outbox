package com.food.ordering.system.order.service.domain;


import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.food.ordering.system.order.service.domain.event.publisher.DomainEventPublisher;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

/* notice: the events are returned as response. This is deliberate so that
    - the events firing process will be from the caller service (application service)
    - since we expect that the underlying business operations should be persisted before event firing and not the other way around
    - hence the question then is where will we interact with the repository ?, that should be the same place we fire the event
    - note if we fire the event in the domain it means we will have to interact with the repository in there too
    - that means complicating the domain core

    - domain core has no knowledge of event publishing or tracking. It only handles core business logic

    WHERE SHOULD THE EVENTS BE CREATED
    - Naturally, domain Entity are responsible for creating domain events as they can be directly called from the application service
    - Because in DDD domain service is not mandatory
    - However it is required when you have access to multiple aggregates in business logic
        - or some logic that does not fit into any entity class
    - However, I prefer integrating a domain-service in front of a domain
        - so application service will not interact directly with the entity, hence events creation can be moved to the domain service

 **/
public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant, DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher);

    OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages, DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher);

    void cancelOrder(Order order, List<String> failureMessages);
}
