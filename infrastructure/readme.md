# Infrastructure


## Kafka
- see if up https://zookeeper.apache.org/doc/r3.9.5/zookeeperAdmin.html#sc_zkCommands
- 
- run order
  - docker-compose -f common.yml -f zookeeper.yml up
  - check if zookeper is healthy:    echo ruok | nc localhost 2181
  - docker-compose -f common.yml -f kafka-cluster up
  - docker-compose -f common.yml -f init_kafka.yml up   --- run only once :: remember we are persisting
  - verify using the interface: localhost:9000
    - Add Cluster: 
      - Cluster Name: food-ordering-system-cluster
      - Cluster Zookeeper Hosts: zookeeper:2181
      - save
      - list again