package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// The explanation for the code below and why Jpa needs parametersEntity Type (e.g., Employee): This tells Spring Data JPA which entity class it should manage. The repository will perform CRUD operations on instances of this entity class.
//
//        Identifier Type (e.g., Long): This tells Spring Data JPA the data type of the primary key for the specified entity. It helps Spring Data JPA to understand how to create queries and perform operations that involve the primary key, such as finding an entity by its ID.
//
//This interface is used so you can use Jpa methods with the employee class
//First parameter is the employee class and the second is the data type of the primary key or id of the employee class

//THis interface is soley used so you can used the JPA crud functionality for the specified class Department
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
