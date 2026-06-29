package com.food.ordering.system.kafka.order.avro.model.order.service.domain;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.message.RestaurantApprovedResponse;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.input.message.listener.restaurantapproval.RestaurantApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalResponseMessageListener {
    @Override
    public void orderApproved(RestaurantApprovedResponse restaurantApprovedResponse) {

    }

    @Override
    public void orderRejected(RestaurantApprovedResponse restaurantApprovedResponse) {

    }
}
