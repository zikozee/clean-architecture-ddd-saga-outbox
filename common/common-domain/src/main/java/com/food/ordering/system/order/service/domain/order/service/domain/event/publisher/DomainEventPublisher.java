package com.food.ordering.system.order.service.domain.order.service.domain.event.publisher;


import com.food.ordering.system.order.service.domain.order.service.domain.event.DomainEvent;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface DomainEventPublisher<T extends DomainEvent> {
    void  publish(T domainEvent);
}
