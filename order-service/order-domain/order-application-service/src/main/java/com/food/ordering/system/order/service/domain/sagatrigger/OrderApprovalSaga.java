package com.food.ordering.system.order.service.domain.sagatrigger;


import com.food.ordering.system.order.service.domain.OrderDomainService;
import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovedResponse;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.event.EmptyEvent;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCancelledPaymentRequestMessagePublisher;
import com.food.ordering.system.saga.SagaStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @dev : Ezekiel Eromosei
 * @date : 06 Aug, 2026
 */


@Slf4j
@Component
@RequiredArgsConstructor
public class OrderApprovalSaga implements SagaStep<RestaurantApprovedResponse, EmptyEvent, OrderCancelledEvent> {

    private final OrderDomainService orderDomainService;
    private final OrderSagaHelper orderSagaHelper;
    private final OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher;

    @Override
    @Transactional
    public EmptyEvent process(RestaurantApprovedResponse restaurantApprovedResponse) {
        log.info("Approving order with id: {}", restaurantApprovedResponse.getOrderId());
        Order order = orderSagaHelper.findOrder(restaurantApprovedResponse.getOrderId());
        orderDomainService.approveOrder(order);
        orderSagaHelper.saveOrder(order);
        log.info("Order with id: {} has been approved", order.getId().getValue());
        return EmptyEvent.INSTANCE;
    }

    @Override
    @Transactional
    public OrderCancelledEvent rollback(RestaurantApprovedResponse restaurantApprovedResponse) {
        log.info("Cancelling order with id: {}", restaurantApprovedResponse.getOrderId());
        Order order = orderSagaHelper.findOrder(restaurantApprovedResponse.getOrderId());
        OrderCancelledEvent orderCancelledEvent = orderDomainService.cancelOrderPayment(order, restaurantApprovedResponse.getFailureMessages(),
                orderCancelledPaymentRequestMessagePublisher);
        orderSagaHelper.saveOrder(order);
        log.info("Order with id: {} is cancelling", order.getId().getValue());
        return orderCancelledEvent;
    }
}
