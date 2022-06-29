# Spring Boot CRUD application

## About
The following repo contains a Spring Boot CRUD example, without the use of postman/insomnia, but as a web application.

## I've learned how to:
* use packages for cleaner code
* use Model class and addAttribute method
* string interpolation to use and manipulate variables
* redirect to views
* extend Throwable in order to create a personalized exception message
* use Service to catch exceptions using if statements for all usefull use cases as the app is developed
* create templates for views
* use thymeleaf, although the syntax isn't recognised in Intellij Community (free version)
* use thymeleaf string interpolation to display messages or insert data from classes, form action for an object with foreach to list all fields, routing
* validate fields properties and rules, e.g. password must be at least 5 characters long

## Run this application:
* create a postgres database named springbootcrud
* update your postgres credentials at resources/application.properties:
```
spring.datasource.username=username
spring.datasource.password=password
```
* run the application and open browser at:
```
http://localhost:8080/
```
### Routing:
* "/" index page:

![img.png](img.png)

* "/users" CRUD table

![img_1.png](img_1.png)

* "/users/new" new user form:

![img_2.png](img_2.png)

* "/users/edit/USER_ID_HERE" edit user form

![img_3.png](img_3.png)

### Warning messages:

![img_4.png](img_4.png)

![img_5.png](img_5.png)

![img_6.png](img_6.png)

![img_7.png](img_7.png)

![img_8.png](img_8.png)

![img_9.png](img_9.png)
 