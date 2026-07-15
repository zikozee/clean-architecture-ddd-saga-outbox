package com.food.ordering.system.order.service.domain.valueobject;


import lombok.Builder;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 29 Jun, 2026
 */

@Builder
public record OrderPreferences(
        List<String> removeIngredients,
        List<String> addIngredients,
        SpiceLevel spiceLevel,
        String specialInstructions,
        String deliveryInstructions
) {
}
