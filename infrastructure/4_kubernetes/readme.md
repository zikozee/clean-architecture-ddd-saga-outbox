# Order of execution

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
