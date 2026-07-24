package com.food.ordering.system.restaurant.service.domain.ports.output.repository;


import com.food.ordering.system.restaurant.service.domain.entity.OrderApproval;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Jul, 2026
 */

public interface OrderApprovalRepository {
    OrderApproval save(OrderApproval orderApproval);
}
