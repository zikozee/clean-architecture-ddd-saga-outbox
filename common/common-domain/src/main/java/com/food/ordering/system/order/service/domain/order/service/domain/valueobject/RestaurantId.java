package com.food.ordering.system.order.service.domain.order.service.domain.valueobject;


import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

public class RestaurantId extends BaseId<UUID> {

    public RestaurantId(UUID value) {
        super(value);
    }
}
