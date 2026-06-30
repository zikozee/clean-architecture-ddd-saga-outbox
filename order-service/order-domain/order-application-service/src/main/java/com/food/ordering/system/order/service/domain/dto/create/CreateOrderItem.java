package com.food.ordering.system.order.service.domain.dto.create;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderItem {
    @NotNull
    private final UUID productId;
    @NotNull
    private final Integer quantity;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final BigDecimal subTotal;
}
