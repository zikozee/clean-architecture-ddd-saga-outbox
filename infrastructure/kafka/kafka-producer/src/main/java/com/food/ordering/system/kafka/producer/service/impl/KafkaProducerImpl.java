package com.food.ordering.system.kafka.producer.service.impl;


import com.food.ordering.system.kafka.producer.exception.KafkaProducerException;
import com.food.ordering.system.kafka.producer.service.KafkaProducer;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @dev : Ezekiel Eromosei
 * @date : 29 Jun, 2026
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    @Override
    public void send(String topic, K key, V message, Consumer<SendResult<K, V>> onSuccess, Consumer<Throwable> onError) {
        log.info("sending message={} to topic={}", message, topic);

        try {

            kafkaTemplate.send(topic, key, message)
                    .whenComplete((result, ex) -> {
                       if(ex != null) {
                           onError.accept(ex);
                       } else {
                           onSuccess.accept(result);
                       }
                    });
        }catch (KafkaException e){
            log.error("Error on kafka producer with key: {}, message: {}, and exception: {}", key, message, e.getMessage());
            throw new KafkaProducerException("Error on kafka producer with key: " + key + " message: " + message);
        }

    }

    @PreDestroy
    public void close(){
        if(kafkaTemplate != null){
            log.info("Closing kafka producer!");
            kafkaTemplate.destroy();
        }
    }
}
