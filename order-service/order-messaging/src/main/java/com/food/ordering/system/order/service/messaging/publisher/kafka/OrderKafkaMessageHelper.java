package com.food.ordering.system.order.service.messaging.publisher.kafka;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

/**
 * @dev : Ezekiel Eromosei
 * @date : 05 Jul, 2026
 */

@Slf4j
@Component
public class OrderKafkaMessageHelper {

    public <T, U> BiConsumer<SendResult<String, T>, Throwable> getKafkaCallBack(String responseTopicName, String orderId, T requestAvroModel, String requestAvroModelName) {

        return (result, ex) -> {
            if (ex == null) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received successful response from Kafka for order id: {} Topic: {}, Partition: {}, Offset: {}, Timestamp: {}",
                        orderId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp()
                );
            }else {
                log.error("Error while sending {} message {} to topic {}", requestAvroModelName, requestAvroModel.toString(), responseTopicName, ex);
            }
        };
    }
}
