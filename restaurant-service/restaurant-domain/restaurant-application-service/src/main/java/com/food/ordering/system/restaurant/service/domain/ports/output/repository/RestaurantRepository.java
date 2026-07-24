package com.food.ordering.system.restaurant.service.domain.ports.output.repository;


import com.food.ordering.system.restaurant.service.domain.entity.Restaurant;

import java.util.Optional;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Jul, 2026
 */

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
