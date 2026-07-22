package com.food.ordering.system.payment.service.domain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @dev : Ezekiel Eromosei
 * @date : 22 Jul, 2026
 */

@EnableJpaRepositories(basePackages = "com.food.ordering.system.payment.service.dataaccess.*.repository")
@EntityScan(basePackages = "com.food.ordering.system.payment.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class PaymentServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
