*** Role ***
You are a Java developer working on a new project, and assigned to set up a new Spring Boot module.
Your setup will work as a foundation and new features will be added upon that.
Show your response step-by-step and present the result in detail.

*** Tasks ***
- Create Spring JPA entity classes based on the given ** Entity Model Design **.
- Create standard CRUD JPA repository for the following entity classes.
    - Customer
    - Product
    - Order
- Prepare DDL scripts for creating new tables in Postgres DB.
- Refer to examples in URLs below, expose the repository functions to REST API by using the Spring Data REST.
    - https://spring.io/guides/gs/accessing-data-rest
- Refer to examples in the URLs below, create the JUnit test cases for the JPA Repository classes:
    - https://www.baeldung.com/junit-datajpatest-repository
    - https://reflectoring.io/spring-boot-data-jpa-test/
- Create a Github action CI/CD pipeline to build and package the project:
    - use the maven task "spring-boot:build-image" into build and pack the docker image.
    - login into the GitHub Registry and push the docker image to it.
- Create INSERT SQL script to create the following testing data:
    - Customer x 5
    - Product x 10
    - Order x 3
- The source codes should be compatible with the versions defined in ** Development Stack **.
- Follow the guidelines and standard defined in ** Design Best Practices **.
- Provide the folder structure and show where all source files should be located.
- The corrections of your previous output could be found in ** Hints **.
- DO NOT SKIP any source code, make sure they can compile and run.

** Design Requirements **
- All Product classes should extend from an abstract product, which has common properties to share to all product.
- Use InheritanceType.JOINED for Product class inheritance strategy.
- The Order entity should associate to the corresponding Customer entity.
- The Order Item entity should associate to both Order and Product entity.
- All entity classes should reside in "com.sportfash.data.entities" package.
- All product subclasses should reside in "com.sportfash.data.entities.product" package.
- All repo classes should reside in "com.sportfash.data.repo" package.
- Create following search functions in the repository classes, they should use native SQL to enhance the performance:
    - Customer: 
        - Search by email, 
        - Search by contact no, 
        - Search by card no,
        - Keyword search by customer's full name,
        - Keyword search by customer's address.
    - Product: 
        - Search by brand,
        - Search by productcategory,
        - keyword search by product name, 
        - keyword search by product description.
    - Order:
        - Search by customer,
        - Search by product, 
        - Search by card no, 
        - Search by shipping address.

** Development Stack **
- JDK 21
- Spring Boot 3.4
- JPA 3.x
- Postgres DB 17.4
- Maven
- CI/CD Pipeline - GitHub Action 

** Design Best Practices **
- All JPA entity classes should extends from an abstract audit class named Audit, the class should have audit fields below:
    - createdBy, 
    - createDate, 
    - lastUpdBy, 
    - lastUpdDate, 
    - ver
- Use Lombok for POJO to prevent boilerplate code of Getter/Setter methods.
- DB Tables should use SERIAL as the data type of the primary for autogenerated key.
- All DB tables should under the "new_sale_platform" schema.
- All audit trail columns in database should assign the default value below:
    - createdBy, lastUpdBy - default value is current_user, 
    - createDate, lastUpdBy - default value is current_timestamp, 
    - ver - default value is 1
- All repository interfaces should extend both "CrudRepository" and "PagingAndSortingRepository" to support CRUD operations, paging and sorting.
- All repository interfaces should be decorated with @Repository annotation, so that Spring Data REST will expose it as REST API.
- Use application.yml instead of application.properties.
- For actions in GitHub Action pipeline, use the latest version when it is available.

** Hints **
- JPA base package has been moved from "javax.persistence" to "jakarta.persistence" since version 3.0 .
- Package for LocalDateTime is java.time.LocalDateTime.

** Entity Model Design **

Customer :
- id
- title
- first name
- last name
- email
- contact no
- date of birth
- payment
    - card no
    - expiry date
    - card holder name
- address
    - address line 1
    - address line 2
    - city
    - country
    - post code

Product :
- id
- code
- category
- brand
- product name
- style
- short description
- unit price

Hoodies (extends from Product):
- size (XS,S,M,L,XL,2XL,3XL)
- color
- composition
- care instructions

Trainers (extends from Product):
- size
- color

Backpack (extends from Product):
- color
- strap type
- material
- fastenings
- pockets
- care instructions
- weatherproof

Order :
- order number
- customer id
- promotion code
- discount
- VAT
- total amount
- payment reference
- shipping address

Order Item:
- order number
- item id
- product id
- short description
- qty
- unit price
- amount