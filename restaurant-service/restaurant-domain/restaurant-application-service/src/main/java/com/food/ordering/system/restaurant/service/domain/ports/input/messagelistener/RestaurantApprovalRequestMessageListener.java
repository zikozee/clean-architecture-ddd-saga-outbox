package com.food.ordering.system.restaurant.service.domain.ports.input.messagelistener;


import com.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Jul, 2026
 */

public interface RestaurantApprovalRequestMessageListener {
    void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest);
}
