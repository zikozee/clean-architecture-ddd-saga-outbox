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
- don't be fooled by the kafka topic name expression check the value for
    - order publisher --> payment listener
    - payment publisher --> order listener
- for testing sake if you check the init-data.sql, the  customer id used in payment-container was the same inserted for order-container
