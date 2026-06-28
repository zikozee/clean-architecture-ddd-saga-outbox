package com.food.ordering.system.order.service.domain.order.service.domain.valueobject;


import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
