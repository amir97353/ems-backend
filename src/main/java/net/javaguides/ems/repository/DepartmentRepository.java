package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


//This interface is used so you can use Jpa methods with the Department class
//First parameter is the Department class and the second is the data type of the primary key or id of the employee class

//THis interface is soley used so you can used the JPA crud functionality for the specified class Department


public interface DepartmentRepository extends JpaRepository <Department,Long> {
}
