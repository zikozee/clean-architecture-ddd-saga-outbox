package com.food.ordering.system.order.service.domain.event;


/**
 * @dev : Ezekiel Eromosei
 * @date : 06 Aug, 2026
 */

public final class EmptyEvent implements DomainEvent<Void> {
    public static final EmptyEvent INSTANCE = new EmptyEvent();

    private EmptyEvent() {
    }

    @Override
    public void fire() {

    }
}
