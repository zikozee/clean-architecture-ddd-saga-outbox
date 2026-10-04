package com.food.ordering.system.saga;

/**
 * @dev : Ezekiel Eromosei
 * @date : 06 Aug, 2026
 */

public interface SagaStep<T> { // don't use ? it breaks generics
    void process(T data);
    void rollback(T data);
}
