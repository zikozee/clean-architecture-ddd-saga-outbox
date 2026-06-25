package com.food.ordering.system.order.service.domain.valueobject;


import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

public class CustomerId extends BaseId<UUID> {

    public CustomerId(UUID value) {
        super(value);
    }
}
