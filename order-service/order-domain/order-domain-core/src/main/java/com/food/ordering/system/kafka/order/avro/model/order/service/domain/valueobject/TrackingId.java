package com.food.ordering.system.kafka.order.avro.model.order.service.domain.valueobject;


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
