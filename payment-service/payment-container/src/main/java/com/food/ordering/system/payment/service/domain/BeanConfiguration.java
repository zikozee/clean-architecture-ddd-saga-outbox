package com.food.ordering.system.payment.service.domain;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 22 Jul, 2026
 */

@Configuration
public class BeanConfiguration {

    @Bean
    PaymentDomainService paymentDomainService() {
        return new PaymentDomainServiceImpl();
    }
}
