package com.food.ordering.system.order.service.domain;


import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovedResponse;
import com.food.ordering.system.order.service.domain.ports.input.message.listener.restaurantapproval.RestaurantApprovalResponseMessageListener;
import com.food.ordering.system.order.service.domain.sagatrigger.OrderApprovalSaga;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static com.food.ordering.system.order.service.domain.entity.Order.FAILURE_MESSAGES_DELIMITER;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalResponseMessageListener {

    private final OrderApprovalSaga orderApprovalSaga;

    @Override
    public void orderApproved(RestaurantApprovedResponse restaurantApprovedResponse) {
        orderApprovalSaga.process(restaurantApprovedResponse);
        log.info("Order is approved with order id: {}", restaurantApprovedResponse.getOrderId());
    }

    @Override
    public void orderRejected(RestaurantApprovedResponse restaurantApprovedResponse) {
        orderApprovalSaga.rollback(restaurantApprovedResponse);
        log.info("Order Approval Saga rollback operation is completed for order id: {} with failure messages: {}",
                restaurantApprovedResponse.getOrderId(), String.join(FAILURE_MESSAGES_DELIMITER, restaurantApprovedResponse.getFailureMessages()));
    }
}
