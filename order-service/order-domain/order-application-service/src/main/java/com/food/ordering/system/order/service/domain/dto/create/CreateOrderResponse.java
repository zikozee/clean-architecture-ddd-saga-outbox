package com.food.ordering.system.order.service.domain.dto.create;


import com.food.ordering.system.order.service.domain.valueobject.OrderStatus;
import jakarta.validation.constraints.NotBlank;
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
public class CreateOrderResponse {
    @NotNull
    private final UUID orderTrackingId;
    @NotNull
    private final OrderStatus orderStatus; // reused from common domain
    @NotBlank
    private final String message;
}
