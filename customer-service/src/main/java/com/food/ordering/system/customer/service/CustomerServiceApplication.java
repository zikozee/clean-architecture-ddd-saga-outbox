package com.food.ordering.system.customer.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @dev : Ezekiel Eromosei
 * @date : 15 Jul, 2026
 */

@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class CustomerServiceApplication {
    static void main(String[] args){
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
