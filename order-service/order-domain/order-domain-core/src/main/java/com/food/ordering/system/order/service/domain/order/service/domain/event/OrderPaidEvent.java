package com.food.ordering.system.order.service.domain.order.service.domain.event;


import com.food.ordering.system.order.service.domain.order.service.domain.entity.Order;

import java.time.ZonedDateTime;


/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */


public class OrderPaidEvent extends OrderEvent {
    public OrderPaidEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
