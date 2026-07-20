package com.food.ordering.system.payment.service.domain.valueobject;


import com.food.ordering.system.order.service.domain.valueobject.BaseId;

import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
