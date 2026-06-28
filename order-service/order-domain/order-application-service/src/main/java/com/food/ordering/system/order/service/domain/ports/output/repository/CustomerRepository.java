package com.food.ordering.system.order.service.domain.ports.output.repository;


import com.food.ordering.system.order.service.domain.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);
}
