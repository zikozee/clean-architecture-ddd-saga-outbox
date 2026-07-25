package com.food.ordering.system.restaurant.service.domain;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 25 Jul, 2026
 */

@Configuration
public class BeanConfiguration {

    @Bean
    RestaurantDomainService restaurantDomainService() {
        return new RestaurantDomainServiceImpl();
    }
}
