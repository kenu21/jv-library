# Library
![Internet-shop](/images/library.jpg)

# Table of Contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For developer](#developer-start)
* [Authors](#authors)

# <a name="purpose"></a>Project purpose
This App can be used as a basis for creating your own online library.
<hr>
This web application has forms for registering users, add books and authentication.

There are also controllers for working with rent and return books.
<hr>
Inject - inject mock data. Available only for ADMIN role.

Registration/login - able to register a new user and authentication and authorization.

Books - show all books.

AddBook - add a new book. Available only for ADMIN role.

Rent - rent book.

Return - return book.

RentBooks - show all rented books for current user.

Logout - for log out.
<hr>

# <a name="structure"></a>Project Structure
* Java 11
* Maven 4.0.0
* Spring context 4.3.7
* Hibernate 5.2.9.Final
* Common dbcp2
* javax.annotation-api 1.3.2
* jaxb-api 2.3.1
* maven-checkstyle-plugin
<hr>

# <a name="developer-start"></a>For developer

Open this project in your IDE.

Add it as maven project.

Configure Tomcat:
* add artifact;
* set application context "/";
* add sdk 11.0.3

Add sdk 11.0.3 in project strukture.

You need sql database.

Create schema "dblibrary".

In librarypattern.src.main.resources.dbproperties class you have to change user and password for you DB.

You can run this project.

By default you have user with role USER and ADMIN (login = admin, password = admin). 
<hr>

# <a name="authors"></a>Authors
* [Iurii](https://github.com/kenu21)
