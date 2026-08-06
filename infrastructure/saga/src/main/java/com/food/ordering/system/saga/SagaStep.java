package com.food.ordering.system.saga;


import com.food.ordering.system.order.service.domain.event.DomainEvent;

/**
 * @dev : Ezekiel Eromosei
 * @date : 06 Aug, 2026
 */

public interface SagaStep<T, S extends DomainEvent, U extends DomainEvent> { // don't use ? it breaks generics
    S process(T data);
    U rollback(T data);
}
