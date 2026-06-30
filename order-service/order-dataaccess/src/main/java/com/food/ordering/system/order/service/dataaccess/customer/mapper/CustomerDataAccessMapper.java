package com.food.ordering.system.order.service.dataaccess.customer.mapper;


import com.food.ordering.system.order.service.dataaccess.customer.entity.CustomerEntity;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.order.service.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 30 Jun, 2026
 */

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}
