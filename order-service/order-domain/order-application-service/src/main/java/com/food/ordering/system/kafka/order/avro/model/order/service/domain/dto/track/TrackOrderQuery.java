package com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.track;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderQuery { // to query latest state of an order
    @NotNull
    private final UUID orderTrackingId;
}
