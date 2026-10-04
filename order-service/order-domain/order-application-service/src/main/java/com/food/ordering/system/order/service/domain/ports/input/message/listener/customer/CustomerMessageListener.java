package com.food.ordering.system.order.service.domain.ports.input.message.listener.customer;


import com.food.ordering.system.order.service.domain.dto.message.CustomerModel;

/**
 * @dev : Ezekiel Eromosei
 * @date : 04 Oct, 2026
 */

public interface CustomerMessageListener {
    void customerCreated(CustomerModel customerModel);
}
