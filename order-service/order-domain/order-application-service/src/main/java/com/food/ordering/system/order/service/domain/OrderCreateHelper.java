package com.food.ordering.system.order.service.domain;


import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.ports.output.ai.order.noteinterpreter.OrderNoteInterpreter;
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository;
import com.food.ordering.system.order.service.domain.valueobject.OrderPreferences;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreateHelper {

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderDataMapper orderDataMapper;
    private final OrderNoteInterpreter orderNoteInterpreter;


    @Transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant =  checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);

        updateOrderPreferences(createOrderCommand, order);

        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        saveOrder(order);
        log.info("Order is created with id {} ", orderCreatedEvent.getOrder().getId().getValue());
        return orderCreatedEvent;
    }

    private void updateOrderPreferences(CreateOrderCommand createOrderCommand, Order order) {
        final String orderNotes = createOrderCommand.getOrderNotes();
        if (orderNotes == null || orderNotes.isEmpty()) {
            order.updateOrderPreferences(OrderPreferences.builder().build());
            return;
        }

        try {
            OrderPreferences orderPreferences = orderNoteInterpreter.interpret(orderNotes);
            order.updateOrderPreferences(orderPreferences);
        }catch (Exception e) {
            log.warn("Encountered error in AI Order Note Interpreter. Skipping order notes!");
            order.updateOrderPreferences(OrderPreferences.builder().build());
        }
    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);

        if(optionalRestaurant.isEmpty()) {
            log.warn("could not find restaurant with restaurant id: {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Could not find restaurant with restaurant id: " + restaurant.getId());
        }
        return optionalRestaurant.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()){
            log.warn("Customer with id {} not found", customerId);
            throw new OrderDomainException("Customer with id " + customerId + " not found");
        }
    }

    private Order saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        if(savedOrder == null) {
            log.error("could not save order!");
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order with id {} saved successfully", savedOrder.getId());
        return order;
    }
}
