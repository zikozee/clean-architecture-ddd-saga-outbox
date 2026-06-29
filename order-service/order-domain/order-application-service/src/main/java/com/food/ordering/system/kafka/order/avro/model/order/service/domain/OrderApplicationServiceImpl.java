package com.food.ordering.system.kafka.order.avro.model.order.service.domain;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
class OrderApplicationServiceImpl implements OrderApplicationService { // package private --> only interface should be called

    private final OrderCreateCommandHandler orderCreateCommandHandler;
    private final OrderTrackCommandHandler orderTrackCommandHandler;

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }
}
