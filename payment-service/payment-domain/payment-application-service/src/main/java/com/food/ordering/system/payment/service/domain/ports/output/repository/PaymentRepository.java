package com.food.ordering.system.payment.service.domain.ports.output.repository;


import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.util.Optional;
import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findByOrderId(UUID orderId);
}
