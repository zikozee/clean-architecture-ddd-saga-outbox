package com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.output.repository;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.entity.Order;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
