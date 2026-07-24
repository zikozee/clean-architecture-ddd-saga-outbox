package com.food.ordering.system.restaurant.service.domain.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Jul, 2026
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "restaurant-service")
public class RestaurantServiceConfigData {

    private String restaurantApprovalRequestTopicName;
    private String restaurantApprovalResponseTopicName;
}
