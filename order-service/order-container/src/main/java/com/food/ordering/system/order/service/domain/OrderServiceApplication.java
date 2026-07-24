package com.food.ordering.system.order.service.domain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @dev : Ezekiel Eromosei
 * @date : 05 Jul, 2026
 */

@EnableJpaRepositories(basePackages = {"com.food.ordering.system.order.service.dataaccess", "com.food.ordering.system.dataaccess"}) // to scan jpa repositories
@EntityScan(basePackages = {"com.food.ordering.system.order.service.dataaccess", "com.food.ordering.system.dataaccess"}) // to locate the jpa entities
@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class OrderServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
