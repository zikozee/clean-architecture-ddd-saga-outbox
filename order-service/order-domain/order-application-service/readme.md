# ORDER APPLICATION SERVICE
- this is the contact point for clients
- I use framework abilities here to make development easier and not in the domain core (which has the core domain logic)
- this should contain the input and output ports (i.e this is where other services talk to the order domain from)
- This is where the events should be fired

## requires 
   - core domain module
   - common module (already in core domain module)
   Data Validation
   - this layer handles data validations 
   - hence requires spring boot data validation
   Transactions
   - this layer also handles transactions 
   - hence requires spring tx dependency

## Avoid validations
  - as that should be handled in the domain core module

- commands are for create
- queries are for inquiry/get


## Ports package: 
holds the corresponding adapters either in the domain layer or infrastructural layer
remember this is how clients or order services talk to the domain via the application-service

  - input ports: interfaces implemented by the domain layer and used by the clients of the domain layer

    - OrderApplicationService - used by clients
    - PaymentResponseMessageListener - message listener (triggered by the domain event from payment service)
    - RestaurantApprovalResponseMessageListener - message listener (triggered by the domain event from restaurant service)


  - output ports: interfaces implemented in the infrastructural layers (e.g data access or messaging module)
    - and used by the domain layer to reach those infrastructure layers
    - 
    - **repository package**
      - it is the responsibility of the the repository to convert to and fro JPA

## publish-event-option-2
- The @TransactionalEventListener in OrderCreatedEventApplicationListener will only work if the publisher (ApplicationDomainEventPublisher)
- is called from a method that has a running Transaction (OrderCreateCommandHandler.createOrder has @Transactional)
- if the transaction succeeds(i.e the whole method with @Transactional executes) then this Listener is triggered