# SkipTheDishesJavaChallenge
Rest API using Java 8, MySQL, Spring Boot, Jersey, Jackson and Reactive Spring-Webflux (for the testing part only)

**IMPORTANT: This description aims to describe the project appropriately. Please, don't
take it into consideration during evaluation.It was written after the 9PM deadline. Thank you! **

## Implemented functionalities:
- Models
- Cousine, Store and Products' controllers. Orders' controller partially implemented
- JPA Repositories
- An example Service that wraps repository queries in Optional results, and validates the data
- An example test class for the Cousine's controller
- data loader to store initial data on the database (currently set to run in the testing profile)
- Jackson/Jersey configuration
- BaseEntity implementing a Jackson based 'JSONification' of entities
- Object Parser with an object Jsonifier

## Unimplemented functionalities:
- JWT/Spring Security authentication
- ElasticSearch FullTextSearch (or even a database implementation). An intermediate solution was manual text searching in
all String fields of an entity (which results in Boilerplate code in the JPA repositories)
- Customer and Order Controllers

## Improvements required:

- Cleaner code overall; more standardization (generic functions, moving business rules to appropriate services, etc)
- A LOT more testing
- More appropriate (and standardized) exception handling
- Simpler testing with Rest Assured, instead of Webflux (which has proven to be too cumbersome)
