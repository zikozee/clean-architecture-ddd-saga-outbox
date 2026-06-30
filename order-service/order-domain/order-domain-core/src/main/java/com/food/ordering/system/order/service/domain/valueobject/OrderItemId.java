package com.food.ordering.system.order.service.domain.valueobject;


import com.food.ordering.system.order.service.domain.valueobject.BaseId;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jun, 2026
 */

//uniqueness of orderItem is only important in the aggregate, so long should be enough
public class OrderItemId extends BaseId<Long> {

    public OrderItemId(Long value) {
        super(value);
    }
}
