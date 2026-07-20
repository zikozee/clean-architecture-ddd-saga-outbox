package com.food.ordering.system.payment.service.domain.config;



import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "payment-service")
public class PaymentServiceConfigData {

    private String paymentRequestTopicName;
    private String paymentResponseTopicName;
}
