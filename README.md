<h1 align="center">Recipe Management System </h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java-21-darkblue.svg" />
  </a>
  <a href="Maven url">
    <img alt="Maven" src="https://img.shields.io/badge/Maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.1-brightgreen.svg" />
  </a>
  <a href="License url">
    <img alt="BSD Clause 3" src="https://img.shields.io/badge/License-BSD_3--Clause-blue.svg"/>
  </a>
</p>
<p align="left">
Recipe Management System application is a Java application built using Maven and the SpringBoot framework.

## Table of Contents

- [Frameworks and Language Used](#frameworks-and-language-used)
- [Dataflow](#dataflow)
- [Data Structure](#data-structure)
- [Project Summary](#project-summary)

## Frameworks and Language Used

- Java: The primary programming language used for developing the application.
- Maven: A build automation tool and dependency management tool used for managing the project's dependencies and building the application.
- SpringBoot: A powerful and widely used framework for building Java-based enterprise applications. It provides features like inversion of control, dependency injection, and seamless integration with various other libraries.

## Dataflow


* <b>Entities</b> : I have four entities in my project namely User , Recipe , Comment , Authentication Token. User entity has the details that user can have like id , name , email , password etc. Recipe has properties id , name of the recipe , ingredients , instructions and Many to One unidirctional mapping with user and one to many bi-directional mapping with comments. Comments has properties namely id , comment , comment creation time stamp , and many to one mapping with the user. Authentication token basically has id , token value and token creation time stamp and one to one mapping with user. It has parameterized constructor which has only user as parameter and token values is generated randomly using UUID when user will sign in.
 
* <b>Controller</b> :The Controller layer handles incoming HTTP requests and directs them to the appropriate service. It mainly deals with request handling, validation, and response generation. so I have three controllers namely User Controller , Recipe Controller and Comment Controller. In user controller I have three end points namely signUp to sign up the user or post the user. The second one is signIn which is basically for to sign for the register user which will ask email and password that is given at the time of sign up and the last one is signOut. Recipe controller has endpoints for crud operations on recipe and that will be used by sign in user only. As all endpoints will need email and token to process further. Comment controller has only one endpoint that is to add comments on a recipe

* <b>Service</b> : The Services layer contains business logic and application-specific operations. It acts as an intermediary between the Controller and the Repository, encapsulating complex functionalities. So I have four service classes for User Controller , Recipe Controller , Comments Controller and for authentication where I have all my logic.

* <b>Repository</b> :The Repository layer is responsible for data access and manipulation. It communicates with the database and performs CRUD (Create, Read, Update, Delete) operations. So I have repositories for each service class. Repositories extending JPA Repositry which allowing us to do crud operations , also allow us to create custom finders and custom queries.

* <b>DataBase Design</b> : I have used MYSQL as my RDBMS. The database designed for this project has tables for each model. The table has columns according to the properties of models. I have used my sql connector dependency in pom for connections to my sql and in applications.properties I have all details about database authentication and name of data base and also about Driver class etc.

## Data Structure

I have used MYSQL as an database to store my data in persistant way.

## Project Summary

<div style:"text-align: justify; text-justify: inter-word;">Recipe management system is simple springboot application that allows user to share their recipes and also they can manage , so that users can see them those who have singned and follow those recipes make their favourite items. Users can post comments on someones recipes if they like them or incase if they wanted to give any suggestions. User must register themselves that is signUp and after that must login in order to use the application. After sign in they cant do anything like they can add , get , remove , update recipes and also comment on someones recipes. Also deployed code on AWS so that every one can user application.</div>

## License

This project is licensed under the [BSD 3-Clause License](LICENSE).

## Contact

For questions or feedback, please contact [Jangam Ranjeeth](mailto:jangamr.jr@gmail.com).

---
