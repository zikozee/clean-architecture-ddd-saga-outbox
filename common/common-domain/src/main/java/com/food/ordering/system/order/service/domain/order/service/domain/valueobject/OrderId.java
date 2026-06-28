package com.food.ordering.system.order.service.domain.order.service.domain.valueobject;


import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

public class OrderId extends BaseId<UUID> {

    public OrderId(UUID value) {
        super(value);
    }
}
