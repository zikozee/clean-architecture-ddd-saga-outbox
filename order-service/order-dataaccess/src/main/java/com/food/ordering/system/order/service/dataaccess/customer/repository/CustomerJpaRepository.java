package com.food.ordering.system.order.service.dataaccess.customer.repository;


import com.food.ordering.system.order.service.dataaccess.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 30 Jun, 2026
 */

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {

}
