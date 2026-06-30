package com.food.ordering.system.application.handler;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @dev : Ezekiel Eromosei
 * @date : 30 Jun, 2026
 */

@Data
@Builder
@AllArgsConstructor
public class ErrorDTO {
    private final String code;
    private final String message;
}
