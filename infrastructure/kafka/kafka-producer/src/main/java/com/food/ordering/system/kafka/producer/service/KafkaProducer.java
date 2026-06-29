package com.food.ordering.system.kafka.producer.service;


import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.support.SendResult;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * @dev : Ezekiel Eromosei
 * @date : 29 Jun, 2026
 */

public interface KafkaProducer<K extends Serializable, V extends SpecificRecordBase> {
    void send(String topic, K key, V message, Consumer<SendResult<K, V>> onSuccess, Consumer<Throwable> onError);
}
