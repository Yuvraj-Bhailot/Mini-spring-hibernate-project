# Mini Spring Hibernate Project

A simple **console-based CRUD application** built using **Spring Framework, Hibernate ORM, and PostgreSQL**.

This project demonstrates how Spring can be integrated with Hibernate and PostgreSQL to perform database operations using JPA/Hibernate.

---

## 🚀 Features

* Console-based application
* Spring Framework integration
* Hibernate ORM for database persistence
* PostgreSQL database integration
* JPA `persistence.xml` configuration
* CRUD database operations
* Automatic table creation/update using Hibernate
* SQL query logging in the console

---

## 🛠️ Technologies Used

| Technology             | Version      |
| ---------------------- | ------------ |
| Java                   | 8+           |
| Spring Context         | 5.3.39       |
| Hibernate Core         | 5.6.15.Final |
| PostgreSQL JDBC Driver | 42.6.0       |
| PostgreSQL             | 12+          |
| JPA                    | 2.1          |

---

## 📋 Prerequisites

Before running the project, make sure you have the following installed:

* Java JDK
* Maven
* PostgreSQL
* IDE such as IntelliJ IDEA, Eclipse, or Spring Tool Suite

You should also have a PostgreSQL database created for the application.

---

## 📦 Maven Dependencies

Add the following dependencies to your `pom.xml`:

```xml
<dependencies>

    <!-- Spring Context -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.39</version>
    </dependency>

    <!-- Hibernate -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.15.Final</version>
    </dependency>

    <!-- PostgreSQL JDBC Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.6.0</version>
    </dependency>

</dependencies>
```

---

## 🗄️ PostgreSQL Setup

Create a PostgreSQL database before running the application.

For example:

```sql
CREATE DATABASE mini_spring_hibernate;
```

Update the database connection details in `persistence.xml` according to your PostgreSQL configuration.

---

## ⚙️ Persistence Configuration

The project uses **JPA's `persistence.xml`** file to configure the database and Hibernate.

The file should be located at:

```text
src/main/resources/META-INF/persistence.xml
```

Example configuration:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
    http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
    version="2.1">

    <persistence-unit name="dbInfo"
        transaction-type="RESOURCE_LOCAL">

        <properties>

            <!-- PostgreSQL Driver -->
            <property name="javax.persistence.jdbc.driver"
                value="org.postgresql.Driver" />

            <!-- Database URL -->
            <property name="javax.persistence.jdbc.url"
                value="jdbc:postgresql://localhost:5432/mini_spring_hibernate" />

            <!-- Database Username -->
            <property name="javax.persistence.jdbc.user"
                value="user" />

            <!-- Database Password -->
            <property name="javax.persistence.jdbc.password"
                value="your_password" />

            <!-- Hibernate Dialect -->
            <property name="hibernate.dialect"
                value="org.hibernate.dialect.PostgreSQLDialect" />

            <!-- Schema Generation -->
            <property name="hibernate.hbm2ddl.auto"
                value="update" />

            <!-- Display SQL -->
            <property name="hibernate.show_sql"
                value="true" />

            <!-- Format SQL -->
            <property name="hibernate.format_sql"
                value="true" />

        </properties>

    </persistence-unit>

</persistence>
```

### Hibernate Schema Configuration

The following property controls how Hibernate handles database tables:

```xml
<property name="hibernate.hbm2ddl.auto" value="update" />
```

Common values are:

| Value         | Description                                                |
| ------------- | ---------------------------------------------------------- |
| `create`      | Drops existing tables and creates new ones                 |
| `create-drop` | Creates tables and drops them when the application stops   |
| `update`      | Updates the existing schema without deleting existing data |
| `validate`    | Validates the schema without modifying it                  |

For development, `update` can be convenient. For production applications, schema migrations are generally preferred.

---

## 🧪 Hibernate SQL Logging

SQL logging is enabled through:

```xml
<property name="hibernate.show_sql" value="true" />
<property name="hibernate.format_sql" value="true" />
```

This allows Hibernate-generated SQL statements to be displayed in the console, which is useful for understanding and debugging database operations.

---

## 🎯 Learning Objectives

This mini-project is useful for understanding:

* Spring dependency injection
* Spring application context
* JPA configuration
* Hibernate ORM
* Entity mapping
* PostgreSQL connectivity
* CRUD operations
* Hibernate-generated SQL

---

## 🔐 Configuration Note

Do **not** commit real database passwords to a public GitHub repository.

Instead of:

```xml
<property name="javax.persistence.jdbc.password"
    value="my-real-password" />
```

use a local configuration or environment-based approach where appropriate.

---


## 👨‍💻 Author

**Yuvi**

---

## 📄 License

This project is available for educational and learning purposes.
