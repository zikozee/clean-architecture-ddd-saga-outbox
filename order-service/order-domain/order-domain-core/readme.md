# This will contain the Core Logic inside this Module

- This will include:
    - Entities
    - Value Objects
    - Domain Services
    - domain events

- notice i avoid using framework or external dependencies here
  - to make it as clean as possible
- this module handles its own domain validation
  - creating the classes, methods and constructors also made validation possible to some extent
  - each entity manages its own validation
  - shared validations is done in the domain-service