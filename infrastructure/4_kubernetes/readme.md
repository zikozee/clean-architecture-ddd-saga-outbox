# Order of execution

1)
- mvn clean install -DskipTests
  - this will auto create the application images into your docker-desktop

2)   -- ensure kubernetes is up and running in docker-desktop
- kafka
  - ./infratructure/4_kubernetes/kafka/run.sh single-node
- postgres
  - kubectl apply -f infrastructure/4_kubernetes/postgres/postgres-deployment.yml
- application
  - kubectl apply -f infrastructure/4_kubernetes/application-deployment-local.yml


to delete 
- kafka
  - kubectl --context docker-desktop -n default delete -k infratructure/4_kubernetes/kafka/single-node --ignore-not-found
- postgres
  - kubectl delete -f infrastructure/4_kubernetes/postgres/postgres-deployment.yml
- application
    - kubectl delete -f infrastructure/4_kubernetes/application-deployment-local.yml
