package com.food.ordering.system.order.service.domain.outbox.model.approval;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @dev : Ezekiel Eromosei
 * @date : 17 Aug, 2026
 */

@Getter
@Builder
@AllArgsConstructor
public class OrderApprovalEventProduct {
    @JsonProperty
    private String id;
    @JsonProperty
    private Integer quantity;
}
