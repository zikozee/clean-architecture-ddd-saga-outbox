package com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.input.service;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.dto.track.TrackOrderResponse;

import jakarta.validation.Valid;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
