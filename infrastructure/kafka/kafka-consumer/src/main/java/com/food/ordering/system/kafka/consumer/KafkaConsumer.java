package com.food.ordering.system.kafka.consumer;


import org.apache.avro.specific.SpecificRecordBase;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 29 Jun, 2026
 */

public interface KafkaConsumer<T extends SpecificRecordBase> {
    void receive(List<T> messages, List<String> keys, List<Integer> partitions, List<Long> offsets);
}
