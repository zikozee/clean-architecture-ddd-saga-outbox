package com.food.ordering.system.restaurant.service.domain.valueobject;


import com.food.ordering.system.order.service.domain.valueobject.BaseId;

import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Jul, 2026
 */

public class OrderApprovalId extends BaseId<UUID> {
    public OrderApprovalId(UUID value) {
        super(value);
    }
}
