package com.food.ordering.system.order.service.application.exception.handler;


import com.food.ordering.system.application.handler.GlobalExceptionHandler;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.kafka.order.avro.model.order.service.domain.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.food.ordering.system.application.handler.ErrorDTO;

/**
 * @dev : Ezekiel Eromosei
 * @date : 30 Jun, 2026
 */

@Slf4j
@RestControllerAdvice
public class OrderGlobalExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(value = {OrderDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(OrderDomainException orderDomainException){
        log.error(orderDomainException.getMessage(), orderDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(orderDomainException.getMessage())
                .build();
    }

    @ExceptionHandler(value = {OrderNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(OrderNotFoundException orderNotFoundException){
        log.error(orderNotFoundException.getMessage(), orderNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(orderNotFoundException.getMessage())
                .build();
    }
}
