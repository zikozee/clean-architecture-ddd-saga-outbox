package com.food.ordering.system.order.service.domain;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 05 Jul, 2026
 */

@Configuration
public class BeanConfiguration {


    /**
    * remember order domain service is present in the core domain, and it's not a bean
    */
    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainServiceImpl();
    }
}
