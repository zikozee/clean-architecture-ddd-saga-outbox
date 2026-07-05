package com.food.ordering.system.order.service.messaging.publisher.kafka;


import com.food.ordering.system.kafka.order.avro.model.PaymentRequestAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.jspecify.annotations.NonNull;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @dev : Ezekiel Eromosei
 * @date : 05 Jul, 2026
 */

@Slf4j
@Component
public class OrderKafkaMessageHelper {

    public <T> @NonNull Consumer<Throwable> onError(T requestAvroModel, String responseTopicName, String requestAvroModelName) {
        return error -> {
            log.error("Error while sending {} message: {} to topic {} ", requestAvroModelName, requestAvroModel.toString(), responseTopicName);
        };
    }

    public <T> @NonNull Consumer<SendResult<String, T>> onSuccess(String orderId) {
        return  result -> {
            RecordMetadata metadata = result.getRecordMetadata();
            log.info("Received successful response from Kafka for order id: {} Topic: {}, Partition: {}, Offset: {}, Timestamp: {}",
                    orderId,
                    metadata.topic(),
                    metadata.partition(),
                    metadata.offset(),
                    metadata.timestamp()
            );
        };
    }
}
