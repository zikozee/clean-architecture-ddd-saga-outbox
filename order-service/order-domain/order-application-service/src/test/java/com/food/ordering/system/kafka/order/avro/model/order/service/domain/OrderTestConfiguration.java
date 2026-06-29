package com.food.ordering.system.kafka.order.avro.model.order.service.domain;


import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.output.message.listener.payment.OrderCancelledPaymentRequestMessagePublisher;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.output.message.listener.payment.OrderCreatedPaymentRequestMessagePublisher;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.output.message.listener.restaurantapproval.OrderPaidRestaurantMessagePublisher;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.output.repository.CustomerRepository;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.output.repository.OrderRepository;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.ports.output.repository.RestaurantRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @dev : Ezekiel Eromosei
 * @date : 28 Jun, 2026
 */

@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class OrderTestConfiguration {

    @Bean
    public OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher() {
        return Mockito.mock(OrderCreatedPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher() {
        return  Mockito.mock(OrderCancelledPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderPaidRestaurantMessagePublisher orderPaidRestaurantMessagePublisher() {
        return Mockito.mock(OrderPaidRestaurantMessagePublisher.class);
    }

    @Bean
    public OrderRepository orderRepository(){
        return Mockito.mock(OrderRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository(){
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public RestaurantRepository restaurantRepository(){
        return Mockito.mock(RestaurantRepository.class);
    }

    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainServiceImpl();
    }

}
