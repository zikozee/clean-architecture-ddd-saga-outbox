# base 

- run mvn clean install 
  - to validate no dependency issue

## VISUALIZING ARCHITECTURE OF PROJECT
- visualize project/service structure with Graphviz 
  - installation instruction from - https://graphviz.org/
  - from  https://github.com/ferstl/depgraph-maven-plugin
    - run command mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.food.ordering.system*:*"
    - OR simply mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false


## notice flow per domain

1. create entities, valueobjects, domain events, domain service
   - we also used common domain module for common classes 
2. call core-module in the application-service which will be the first contact point for a client request
3. notice that in DDD concept we have created a domain-service to drive the business logic in the domain core module
   - this can be likened to the uses cases in clean architecture
 

# check event in kafka topic
kcat -C -b localhost:19092 -t payment-request


# FLOW
- order -><- payment
- order -><- restaurant (to complete payment) 
- i.e **order service** to **payment service** when payment is completed, then order is sent to **restaurant service** for completion
- don't be fooled by the kafka topic name expression check the value for
    - order publisher --> payment listener
    - payment publisher --> order listener
- for testing sake if you check the init-data.sql, the  customer id used in payment-container was the same inserted for order-container


## OUTBOX PATTERN UPDATED FLOW
- outbox ensures/entails domain-events and db operations are processed in a same ACID transaction
  - events -> saved to outbox table(s)
  - db opertaions -> saved/read from order/payment/restaurant tables

- 1. Order Service
- created a payment-outbox-object (save) from the orderCreatedEvent in orderCreateCommandHandler with outbox status STARTED
- then the PaymentOutboxScheduler fetch this data and publish it to **_payment-request_** topic
- 
- 2. Payment Service
- then payment-service listens to the **_payment-request_**, process payments and publish the result to **_payment-response_** topic
- 
- 3. Order Service
- the listener for **_payment-response_** topic calls the **_process_** method of the OrderPaymentSaga (MAIN SPRING TRANSACTION CASCADED FROM process method)
  - the order status is updated to paid in the process method via the orderDomainService.payOrder
  - which returns the orderPaidEvent, then order is updated
  - after which we update the payment-outbox-object with the new order and saga statuses via the paymentOutboxHelper
  - In same saga flow, we have created approvalEvents in the approval-outbox-tbale via the approvalOutboxHelper
- now When the RestaurantApprovalOutboxScheduler runs, it will read this event and publish it to the **_restaurant-approval-request topic_**
- 
- 4. Restaurant-Service
- the listener for **_restaurant-approval-request_** topic will listen and process 
- continue from 86 - part2