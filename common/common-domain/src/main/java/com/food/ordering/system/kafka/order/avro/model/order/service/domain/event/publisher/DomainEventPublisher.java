package com.food.ordering.system.kafka.order.avro.model.order.service.domain.event.publisher;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.event.DomainEvent;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface DomainEventPublisher<T extends DomainEvent> {
    void  publish(T domainEvent);
}
