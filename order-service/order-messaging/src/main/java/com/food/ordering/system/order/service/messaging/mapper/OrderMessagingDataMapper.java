package com.food.ordering.system.order.service.messaging.mapper;


import com.food.ordering.system.kafka.order.avro.model.*;
import com.food.ordering.system.order.service.domain.dto.message.CustomerModel;
import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;
import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse;
import com.food.ordering.system.order.service.domain.outbox.model.approval.OrderApprovalEventPayload;
import com.food.ordering.system.order.service.domain.outbox.model.payment.OrderPaymentEventPayload;
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

    public PaymentResponse paymentResponseAvroModelToPaymentResponse(PaymentResponseAvroModel responseAvroModel){
        return PaymentResponse.builder()
                .id(responseAvroModel.getId().toString())
                .sagaId(responseAvroModel.getSagaId())
                .paymentId(responseAvroModel.getPaymentId().toString())
                .customerId(responseAvroModel.getCustomerId().toString())
                .orderId(responseAvroModel.getOrderId().toString())
                .price(responseAvroModel.getPrice())
                .createdAt(responseAvroModel.getCreatedAt())
                .paymentStatus(PaymentStatus.valueOf(responseAvroModel.getPaymentStatus().name()))
                .failureMessages(responseAvroModel.getFailureMessages())
                .build();
    }

    public RestaurantApprovalResponse approvalResponseAvroModelToApprovalResponse(RestaurantApprovalResponseAvroModel responseAvroModel) {
        return RestaurantApprovalResponse.builder()
                .id(responseAvroModel.getId().toString())
                .sagaId(responseAvroModel.getSagaId())
                .restaurantId(responseAvroModel.getRestaurantId().toString())
                .orderId(responseAvroModel.getOrderId().toString())
                .createdAt(responseAvroModel.getCreatedAt())
                .orderApprovalStatus(OrderApprovalStatus.valueOf(responseAvroModel.getOrderApprovalStatus().name()))
                .failureMessages(responseAvroModel.getFailureMessages())
                .build();
    }

    public PaymentRequestAvroModel orderPaymentEventToPaymentRequestAvroModel(String sagaId, OrderPaymentEventPayload orderPaymentEventPayload) {
        return PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(sagaId)
                .setCustomerId(UUID.fromString(orderPaymentEventPayload.getCustomerId()))
                .setOrderId(UUID.fromString(orderPaymentEventPayload.getOrderId()))
                .setPrice(orderPaymentEventPayload.getPrice())
                .setCreatedAt(orderPaymentEventPayload.getCreatedAt().toInstant())
                .setPaymentOrderStatus(PaymentOrderStatus.valueOf(orderPaymentEventPayload.getPaymentOrderStatus()))
                .build();
    }

    public RestaurantApprovalRequestAvroModel
        orderApprovalEventToRestaurantApprovalRequestAvroModel(String sagaId,
                                                               OrderApprovalEventPayload orderApprovalEventPayload) {
        return RestaurantApprovalRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(sagaId)
                .setOrderId(UUID.fromString(orderApprovalEventPayload.getOrderId()))
                .setRestaurantId(UUID.fromString(orderApprovalEventPayload.getRestaurantId()))
                .setRestaurantOrderStatus(RestaurantOrderStatus.valueOf(
                        orderApprovalEventPayload.getRestaurantOrderStatus()))
                .setProducts(orderApprovalEventPayload.getProducts().stream().map(orderApprovalEventProduct ->
                        Product.newBuilder()
                                .setId(UUID.fromString(orderApprovalEventProduct.getId()))
                                .setQuantity(orderApprovalEventProduct.getQuantity())
                                .build())
                        .toList())
                .setPrice(orderApprovalEventPayload.getPrice())
                .setCreatedAt(orderApprovalEventPayload.getCreatedAt().toInstant())
                .build();
    }

    public CustomerModel customerAvroModelToCustomerModel(CustomerAvroModel customerAvroModel) {
        return CustomerModel.builder()
                .id(customerAvroModel.getId().toString())
                .username(customerAvroModel.getUsername())
                .firstName(customerAvroModel.getFirstName())
                .lastName(customerAvroModel.getLastName())
                .build();
    }
}
