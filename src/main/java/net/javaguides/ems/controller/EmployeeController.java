package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
//@CrossOrigin Allows any request to this url. It allows react to fetch from this url
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
//the class-level @RequestMapping in a controller provides a common base URL path for all methods within that controller. The methods below that have a url endpoint is added to the base url ex api/employees/{id}. This would be the full endpoint for the getEmployeeById
public class EmployeeController {
    private EmployeeService employeeService;
    //Here is the dependency injection that comes from the interface EmployeeService and this allows you to use the methods that are defined in EmployeeServiceImpl. EmployeeServiceImpl implements EmployeeService and defines the methods.

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        //Since we're using a rest controller a json object is returned. Then RequestBody annotation is used to convert that in to a EmployeeDto object
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        //employee.Service is referencing the interface and .createEmployee is referencing the method that's in the EmployeeServiceImpl
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //gets one employee
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }


    //get all employees
@GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }

    //Build update employee rest api
@PutMapping ("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee (@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);

    }

    //Build delete Employee
@DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.ok("Employee deleted successfully");
    }
}
