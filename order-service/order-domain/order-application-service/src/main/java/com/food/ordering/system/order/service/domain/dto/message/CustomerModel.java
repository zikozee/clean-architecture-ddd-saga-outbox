package com.food.ordering.system.order.service.domain.dto.message;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @dev : Ezekiel Eromosei
 * @date : 04 Oct, 2026
 */

@Getter
@Builder
@AllArgsConstructor
public class CustomerModel {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
}
