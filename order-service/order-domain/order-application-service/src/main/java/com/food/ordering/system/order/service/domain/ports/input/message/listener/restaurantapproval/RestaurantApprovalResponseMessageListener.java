package com.food.ordering.system.order.service.domain.ports.input.message.listener.restaurantapproval;


import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovedResponse;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface RestaurantApprovalResponseMessageListener {

    void orderApproved(RestaurantApprovedResponse restaurantApprovedResponse);

    void orderRejected(RestaurantApprovedResponse restaurantApprovedResponse);
}
