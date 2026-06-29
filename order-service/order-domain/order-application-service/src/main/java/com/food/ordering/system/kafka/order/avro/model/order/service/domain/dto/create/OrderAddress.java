package com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.create;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@Getter
@Builder
@AllArgsConstructor
public class OrderAddress {
    @NotBlank
    @Max(value = 50)
    private final String street;
    @NotBlank
    @Max(value = 10)
    private final String postalCode;
    @NotBlank
    @Max(value = 50)
    private final String city;
}
