# BlueSpurs Interview Test

## Task 1

Your task is to create a RESTful web service endpoint that allows a client to input a product name as a GET query parameter and returns the cheapest product.

Provided below are API keys for the BestBuy and Walmart APIs. Your result should return the best (minimum) price for the product and which store to buy it from. If there are multiple products, always return the lowest priced product. For example:

**Request**
```
GET /product/search?name=ipad
```

**Example Response**
```
200 OK

{
    "productName": "iPad Mini",
    "bestPrice": "150.00",
    "currency": "CAD",
    "location": "Walmart"
}
```

## Task 2 (optional)

A second optional task is another RESTful web service endpoint that allows a client to input an email address and product name as a JSON object in the HTTP body.

Using the `EmailService`, every time the minimum price decreases for the specified item, send an email to the specified email address indicating that the price has dropped.

**Example Request**
```
POST /product/alert
{
    "productName": "ipad",
    "email": "someone@somewhere.com"
}
```

**Example Response**
```
200 OK

(no response body)
```

**Example Email**
```
Sending email to 'someone@somewhere.com' with subject 'The price of the ipad has dropped!' and message 'The price of the ipad has dropped from 150.00CAD to 148.00CAD! Get it quick!'
```

*Note that when using the `EmailService`, no emails are actually sent. A string similar to the example email will be logged in the console.*

## Required API Keys

**BestBuy**: `pfe9fpy68yg28hvvma49sc89`

**Walmart**: `rm25tyum3p9jm9x9x7zxshfa`

## When You're Finished...

Commit this project *to your **own** Git repository* on Github or Bitbucket and email us the link to the repository.

# Starter Kit Documentation

**NOTE 1: Commands and file paths in this documentation are relative to the project root unless otherwise specified.**

This starter kit is meant to help quickly get projects up and running for developers. We want to avoid time spent setting up environments and worrying about boilerplate. The goals are:

- Reduce project start-up friction.
- Introduce a common base for all projects.
- Reduce developer environment dependencies.
- Standardize deployments.
- Follow best practices!

## Key Features

- Gradle build tools.
- Liquibase database migrations and changeset generation based on JPA entity changes.
- Hibernate as the JPA vendor.
- Input validation using the Hibernate Validator.
- MySQL support by default, configurable to use almost any RDBMS.
- Unit and integration tests.
- In-memory caching by default, configurable to use other providers such as Redis, Memcache, or EhCache.
- Cross-origin resource sharing (CORS) enabled by default.
- Spring projects including Boot, Data, Security, Devtools, and HATEOAS.
- A basic user system (registration, login, update profile, directory).
- HTTP Basic authentication.
- Tomcat hooks for WAR container deployment.
- Logging using SLF4J.
- Test code coverage reporting.

# Getting Started

## What You Need

To get started, you'll need 2 things:

1. The Java JDK (development kit) version 1.8.
2. The text editor or IDE of your choice.

Additional setup instructions are provided for IntelliJ IDEA and Eclipse. (You can contribute your own setup instructions for other IDEs!)

## Configuring and Running the Project

Configuration values can be found in the `src/main/resources/application.properties` file. For a development environment, these defaults should work out of the box. If you configured MySQL to use a password, then you will need to configure it here.

**NOTE 2: Do NOT commit your database password to source control!**

## Running the Development Server

To run the project, issue the command `./gradlew bootRun` (on Windows, omit `./`). After some time, you should be able to open `http://localhost:8080` in your web browser to see the text, *"The Bluespurs Spring Starter Kit is running properly."*

## Running Tests

You can run tests using gradle by executing `./gradlew cleanTest test`. To generate a code coverage report, run `./gradlew jacocoTestReport`.

## Running the Project in IntelliJ

After opening IntelliJ, if you have any projects open, choose `File -> Close Project`.

From the start screen, follow these steps:

1. Open project...
2. Navigate to the `settings.gradle` file and select it.
3. In the gradle settings dialog, enable `Use auto-import` and set the JVM to version 1.8.
4. Click OK. Once IntelliJ is finished building the project, navigate to `Run -> Edit Configurations...`.
5. Create a new configuration (click the `+` icon) and choose `Gradle`.
    - Name it anything, like `Development Server`.
    - Enable `Single instance only`.
    - Choose the gradle project.
    - Set the task to `bootRun`.
6. Create a new configuration and choose `JUnit`.
    - Name it `Unit Tests`.
    - Set the test kind to `Category`.
    - Set the category to `com.bluespurs.starterkit.IntegrationTest`.
    - Set the search to `Whole project`.
7. Create a new configuration and choose `JUnit`.
    - Name it `Integration Tests`.
    - Set the test kind to `Category`.
    - Set the category to `com.bluespurs.starterkit.UnitTest`.
    - Set the search to `Whole project`.

Now that the run configurations are set up, you can run or debug the application and it's tests. Once the development server is running, it is not necessary to reboot it after every change. Simply recompile the project (`Build -> Make Project` or `Ctrl-F9`) and the changes will be reloaded.

## Running the Project in Eclipse

These instructions are for Eclipse Mars using the regular flavour of Eclipse (Eclipse Java SE or Eclipse for Java Developers - not Eclipse Java EE).

1. In Eclipse, follow `File -> Import...` and expand `Gradle` to select `Gradle Project`.
2. Choose `Next`.
3. Select the root directory. Leave all of the settings as-is and navigate through the dialogs. Click `Finish`.
4. Eclipse will build the project.
5. Navigate to `Run -> Run Configurations`.
6. Add a new `Gradle Project` run configuration:
    - Name it anything, like `Development Server`.
    - Set the task to `bootRun`.
7. Add a new `JUnit` run configuration:
    - Name it anything, like `Tests`.
    - Select `Run all tests in the selected project`.
    - Set the test runner to `JUnit 4`.

You can now run the application and it's tests.

# Understanding the Starter Kit

The Spring Framework uses a variety of design patterns that users should familiarize themselves with in order to take advantage of the framework in full. Spring makes an effort to make itself more manageable by providing Spring Boot. Spring Boot helps developers get started writing production-grade Java applications with very little configuration. Most of the configuration is handled automatically with the ability to be overridden as needed by the developer.

A comprehensive overview of Spring Boot can be found here: [Spring Boot v1.3.2.RELEASE single page documentation](http://docs.spring.io/spring-boot/docs/1.3.2.RELEASE/reference/htmlsingle/)

As much as possible, following the [S.O.L.I.D software design principles](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)) when developing software leads to systems that, over time, tend to be more extensible and maintainable while removing code smells. Spring embraces such principles.

Prior to Spring version 4, most configuration was done using XML files. Today, *[annotation](https://en.wikipedia.org/wiki/Java_annotation) driven* configuration is encouraged. This starter kit uses annotation driven configuration exclusively.

## Getting Familiar with the Stack

A brief description of the technologies used in the starter kit:

- **REST** (Representation State Transfer) is an architectural style used to build applications that embrace HTTP as the data transport protocol. HATEOAS (Hypermedia as the Engine of Application State) is used for *service discovery* in REST applications.
- **Gradle** is a *build tool* which manages the compiling/packaging process and other tasks, such as downloading other Java packages (typically JAR files) that are depended on. Spring Boot is one such dependency that is managed by Gradle.
- **Spring** is a Java framework. It is comprised of many projects (such as Spring Boot or Spring Security) that can be used interchangeably. For example, it is possible to use the Spring Web project without using Spring Boot. Some projects complement other projects, but can be interchanged with other implementations due to the Java Specification Requests (JSR) which set standards for frameworks such as Spring.
- **JPA** is the *Java Persistence API* which, as the result of a JSR, provides a standard interface for interacting with different database systems. It is important to understand that the JPA is just a specification.
- **Hibernate** is an implementation of the JPA. Along with other capability, Hibernate offers a concrete implementation of the JPA. There are other implementations such as EclipseLink. In Java terms: if the JPA is the interface, then Hibernate is the class.
- **Spring Data** is an abstraction of the JPA. Because the JPA is complex, the Spring Framework offers a project called Spring Data which offers an easier-to-use API for working with the JPA. *Repositories* (explained later) are an example of this abstraction.
- **Liquibase** is a utility used for making changes to the database. In production, managing changes to the database is tricky. Liquibase makes such changes standardized and manageable.

If you're new to these technologies, it is important to understand their respective roles in the development process.

## Common Design Patterns in Spring

- **Inversion of Control with Dependency Injection** (IoC and DI): Rather than having objects that define and instantiate their own associations (dependencies), IoC is the idea that objects only need to define their dependencies, and have an external object (often called the *container*) instantiate the correct instances. DI is a design pattern that enables IoC.
    - [Inversion of Control Containers and the Dependency Injection pattern - Martin Fowler](http://www.martinfowler.com/articles/injection.html)
    - [Inversion of Control and Frameworks - Martin Fowler](http://martinfowler.com/bliki/InversionOfControl.html)
    - [What in the world are Spring Beans? - Stack Overflow](http://stackoverflow.com/questions/17193365/what-in-the-world-are-spring-beans)
    - [The IoC Container and Beans - Spring Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html)
- **Data Transfer Objects** (DTO): A simple method of representing data to be transferred from one system to another (common prior to serialization). This starter kit uses the DTO pattern in two places: input and output. Input classes are stored in `com.bluespurs.starterkit.controller.request` and classes are stored in `com.bluespurs.starterkit.controller.resource`. These classes are only used to transfer data into and out of the system.
    - [Data Transfer Object - Patterns of Enterprise Application Architecture - Martin Fowler](http://martinfowler.com/eaaCatalog/dataTransferObject.html)
- **Repositories and Specifications**: Repositories are a domain-specific (business-specific) abstraction to *Data Access Objects* (DAO), a common design pattern for CRUD (create, read, update, delete) operations on a database. Because we use the JPA to manage low-level data access, we avoid the need for DAO which allows us to think about software in a more domain-oriented sense. Specifications are simple objects used to locate data in a decoupled, reusable manor.
    - [What is the difference between DAO and Repository patterns? - Stack Overflow](http://stackoverflow.com/questions/8550124/what-is-the-difference-between-dao-and-repository-patterns)
    - [Repository - Patterns of Enterprise Application Architecture - Martin Fowler](http://martinfowler.com/eaaCatalog/repository.html)

## Starter Kit Architecture Pattern

In many Java applications (not exclusive to Spring), it is common to see a 3-tier architecture that resembles an MVC structure.

> There is no problem in computer science that cannot be solved by adding another layer of indirection, except having too many layers of indirection. - David Wheeler *or* Butler Lampson

- **Controllers** handle I/O and talk to *services*.
- **Services** perform business logic (including transactional work and caching) and talk to *repositories*.
- **Repositories** manage data access in a domain context and talk to the *DAO*. Because our DAO is provided by the JPA, our layering stops here.

You may have noticed that this is a layered architecture. For example, controllers should not talk to repositories directly. Layers should only communicate with those directly above or below it. This, of course, is a *pattern* not a rule.

## Common Anti-patterns to Avoid

**NOTE 3: Anti-patterns are a sensitive subject because they are tied closely to opinion. In fact, some people argue that using design patterns *at all* is an anti-pattern because not enough abstraction was provided.**

The following anti-patterns are code that is typically found in software, but lead to unmaintainable, highly coupled, less cohesive, or issue-prone code.

- **God object (or BaseBean, or CallSuper)** is an anti-pattern in which objects have too much responsibility or know too much information. God objects violate the single responsibility principle. Instead, use composition.
    - Beware of any class name starting with `Base`. `Base` objects typically provide methods to child classes that model disjoint problems and therefore lead to a bloated, less cohesive object hierarchy. Remember that composition is more flexible than inheritance.
- **Interface bloat** is an anti-pattern that arises when an interface becomes too powerful (defines too many methods) that end up making it difficult or impossible to implement for more than one concrete implementation.

# Development Topics

## Consuming from the Client Side

By default, the starter kit uses [HTTP Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication) and has CORS enabled by default. You can interface with the controllers using ajax logic similar to the following (pseudo-code):

```javascript
ajax({
    url: '/path/to/controller',
    method: 'get',
    type: 'json',
    headers: {
        'Authorization': 'Basic ' + btoa(username + ':' + password)
    }
})
.then(function(response) { ... })
.fail(function(response) { ... })
.always(function() { ... });
```

For testing, Postman (a Google Chrome extension) is useful for making API calls.

## Making Database Schema Changes

For the most part, the database schema will be managed by Liquibase. Liquibase uses JPA entity annotations to construct a schema that will work with your domain objects. Because of this, making schema changes has a typical workflow:

1. Make your changes to the classes inside `com.bluespurs.starterkit.domain`. Be sure to include the appropriate annotations and include mutation methods.
2. Use your modified domain objects as if the schema exists to build your feature.
3. Once content with the changes, run `./gradlew diffChangeLog`. This writes schema changes to the Liquibase changelog located in `src/main/resources/db-changelog.xml`.
4. Make sure the changes discovered by Liquibase meet your expectations.
5. Run Liquibase by re-compiling your project with the development server running, or by using gradle.

## Accessing the Currently Authenticated User

Getting the currently authenticated user who is making the request can be done at any layer, but is typically done in the controller layer and passed down. To access this information, simply inject the `CurrentUser` instance using Spring's `@Autowire` annotation at the member or constructor level.

```java
@Autowired
private CurrentUser currentUser;
.
.
.
public void someMethod() {
    if(currentUser.isAuthenticated()) {
        User user = currentUser.get();
    }
}
```

Calling `CurrentUser#get()` when the user is not authenticated throws a `SecurityException`.

## Restricting Access to Specific Roles

[Spring Security](http://projects.spring.io/spring-security/) has an annotation, `@Secured`, for this purpose. Any method that needs a certain privilege to run can be annotated. If the user does not supply credentials to a secured method, Spring will terminate the request and generate an HTTP 401 Unauthorized response. If credentials are supplied but the user does not have the permission (role) required to access the method, Spring will terminate the request and generate an HTTP 403 Forbidden response.

The starter kit has 2 predefined roles: User and Admin.

```java
@RestController
class MyController {
    @Secured({ Role.USER })
    public String onlyUsers() {
        return "Only users can access this method.";
    }

    @Secured({ Role.ADMIN })
    public String onlyAdmins() {
        return "Only admins can access this method.";
    }
}
```

`@Secured` can be used on controllers, services, or repositories.

## Validating User Input

Input validation is handled by the [Hibernate Validator](http://hibernate.org/validator/) library. Validation can be done on user input (namely POST and PUT HTTP verbs) by creating a class inside of `com.bluespurs.starterkit.controller.request` and annotating the fields appropriately. For example, a registration input class may look like this:

```java
public class UserRegistrationRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Length(min = 8, max = 72)
    private String password;

    // Getters and setters omitted.
}
```

To use this class, simply accept it as an argument to any controller method (make sure to annotate it with `@Valid @RequestBody` to tell Spring that it needs to be validated and that the data comes from the HTTP request body):

```java
@RestController
class MyController {
    @RequestMapping(method = RequestMethod.POST)
    public void registerNewUser(@Valid @RequestBody UserRegistrationRequest request) {
        // Use getter and setter methods to access user input.
    }
}
```

If validation fails, Spring will terminate the request and generate an HTTP 400 Bad Request response.

# Deployment Topics

## Generating a WAR

The starter kit is only configured to run inside of a Tomcat servlet container. To generate the WAR file, run: `./gradlew bootRepackage`. For this project, `bootRepackage` has been configured to depend on `test`, meaning that a WAR file cannot be deployed if any tests are failing.