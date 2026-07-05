package com.food.ordering.system.order.service.messaging.mapper;


import com.food.ordering.system.kafka.order.avro.model.*;
import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;
import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovedResponse;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.food.ordering.system.order.service.domain.valueobject.OrderApprovalStatus;
import com.food.ordering.system.order.service.domain.valueobject.PaymentStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 30 Jun, 2026
 */

@Component
public class OrderMessagingDataMapper {

    public PaymentRequestAvroModel orderCreatedEVentToPaymentRequestAVroModel(OrderCreatedEvent orderCreatedEvent) {
        Order order = orderCreatedEvent.getOrder();

        return PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId("")
                .setCustomerId(order.getCustomerId().getValue())
                .setOrderId(order.getId().getValue())
                .setPrice(order.getPrice().getAmount())
                .setCreatedAt(orderCreatedEvent.getCreatedAt().toInstant())
                .setPaymentOrderStatus(PaymentOrderStatus.PENDING)
                .build();
    }

    public PaymentRequestAvroModel orderCancelledEVentToPaymentRequestAVroModel(OrderCancelledEvent orderCancelledEvent) {
        Order order = orderCancelledEvent.getOrder();

        return PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId("")
                .setCustomerId(order.getCustomerId().getValue())
                .setOrderId(order.getId().getValue())
                .setPrice(order.getPrice().getAmount())
                .setCreatedAt(orderCancelledEvent.getCreatedAt().toInstant())
                .setPaymentOrderStatus(PaymentOrderStatus.CANCELLED)
                .build();
    }

    public RestaurantApprovalRequestAvroModel orderPaidEventToRestaurantApprovalRequestAvroModel(OrderPaidEvent orderPaidEvent) {

        Order order = orderPaidEvent.getOrder();

        return RestaurantApprovalRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId("")
                .setOrderId(order.getId().getValue())
                .setRestaurantId(order.getRestaurantId().getValue())
                .setOrderId(order.getId().getValue())
                .setRestaurantOrderStatus(RestaurantOrderStatus.valueOf(order.getOrderStatus().name()))
                .setProducts(order.getItems().stream()
                        .map(orderItem -> Product.newBuilder()
                                .setId(orderItem.getProduct().getId().getValue())
                                .setQuantity(orderItem.getQuantity())
                                .build()
                        ).toList()
                )
                .setPrice(order.getPrice().getAmount())
                .setCreatedAt(orderPaidEvent.getCreatedAt().toInstant())
                .setRestaurantOrderStatus(RestaurantOrderStatus.PAID)
                .build();

    }

    public PaymentResponse paymentResponseAvroModelToPaymentResponse(PaymentResponseAvroModel responseAvroModel){
        return PaymentResponse.builder()
                .id(responseAvroModel.getId().toString())
                .sagaId(responseAvroModel.getSagaId().toString())
                .paymentId(responseAvroModel.getPaymentId().toString())
                .customerId(responseAvroModel.getCustomerId().toString())
                .orderId(responseAvroModel.getOrderId().toString())
                .price(responseAvroModel.getPrice())
                .createdAt(responseAvroModel.getCreatedAt())
                .paymentStatus(PaymentStatus.valueOf(responseAvroModel.getPaymentStatus().name()))
                .failureMessages(responseAvroModel.getFailureMessages())
                .build();
    }

    public RestaurantApprovedResponse approvalResponseAvroModelToApprovalResponse(RestaurantApprovalResponseAvroModel responseAvroModel) {
        return RestaurantApprovedResponse.builder()
                .id(responseAvroModel.getId().toString())
                .sagaId(responseAvroModel.getSagaId().toString())
                .restaurantId(responseAvroModel.getRestaurantId().toString())
                .orderId(responseAvroModel.getOrderId().toString())
                .createdAt(responseAvroModel.getCreatedAt())
                .orderApprovalStatus(OrderApprovalStatus.valueOf(responseAvroModel.getOrderApprovalStatus().name()))
                .failureMessages(responseAvroModel.getFailureMessages())
                .build();
    }
}
