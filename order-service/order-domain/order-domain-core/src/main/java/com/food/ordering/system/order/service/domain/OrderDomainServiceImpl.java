package com.food.ordering.system.order.service.domain;


import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Product;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.food.ordering.system.order.service.domain.DomainConstants.UTC;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService{

    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        validateRestaurant(restaurant);
        setOrderProductInformation(order, restaurant);
        order.validateOrder();
        order.initializeOrder();
        log.info("Order with id:{} has been initialized", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id:{} has been paid", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    //i don't fire an event as it's one of the last step in order processing,
    // instead the client will fetch the data with get endpoint and the tracking-id instead of implementing the client as an event consumer
    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id:{} has been approved", order.getId().getValue());
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id: {}", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    // not i return nothing(no event) as it's the final step in the process
    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order with id: {} is cancelled", order.getId().getValue());
    }

    private void validateRestaurant(Restaurant restaurant) {
        if(!restaurant.isActive()){
            throw new OrderDomainException("Restaurant with id " + restaurant.getId().getValue() + " is currently not active!");
        }
    }

    //we can optimize this using an HashMap,in a linear time with small space cost
    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        //        order.getItems().forEach(item -> {
//            restaurant.getProducts().forEach(restaurantProduct -> {
//                Product currentProduct = item.getProduct();
//                if(currentProduct.equals(restaurantProduct)){
//                    currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(), restaurantProduct.getPrice());
//                }
//            });
//        });
        Map<Product, Product> productMap = restaurant.getProducts().stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        order.getItems().forEach(item -> {
            Product currentProduct = item.getProduct();
            Product restaurantProduct = productMap.get(currentProduct);

            if (restaurantProduct != null) {
                currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(), restaurantProduct.getPrice());
            }
        });


    }
}
