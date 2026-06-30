package com.food.ordering.system.order.service.application.rest;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 30 Jun, 2026
 */

@Slf4j
@RestController
@RequestMapping(path = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OrderController {
    private final OrderApplicationService orderApplicationService;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        log.info("Creating order for customer: {} at restaurant: {}", createOrderCommand.getCustomerId(),
                createOrderCommand.getRestaurantId());

        CreateOrderResponse createOrderResponse = orderApplicationService.createOrder(createOrderCommand);
        log.info("Order created with tracking id: {}", createOrderResponse.getOrderTrackingId());
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping(path = "{trackingId}")
    public ResponseEntity<TrackOrderResponse> getOrderByTrackingId(@PathVariable UUID trackingId){
        TrackOrderResponse trackOrderResponse = orderApplicationService.trackOrder(TrackOrderQuery.builder()
                .orderTrackingId(trackingId).build());

        log.info("Returning order status with trackingId: {}", trackOrderResponse.getOrderTrackingId());
        return ResponseEntity.ok(trackOrderResponse);
    }
}
