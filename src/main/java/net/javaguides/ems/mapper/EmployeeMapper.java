package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId()
        );
    }

    // this Java class provides two static methods for converting between Employee and EmployeeDto objects, making it easy to map data between these two classes when needed. This can be useful, for example, when transferring data between different layers of an application, such as between a data access layer and a presentation layer.

//These two methods map the employee to employeedto. The above returns a new EmployeeDto and the and takes employee class as a parameter and The below returns a new employee and takes employeedto as a parameter

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }
}


