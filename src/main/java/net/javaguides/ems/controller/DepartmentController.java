package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
//@CrossOrigin Allows any request to this url. It allows to react to fetch from this url
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

//    the dependency injection from the interface DepartmentService allows me to use the methods of all the classes that implement this interface which in this case is DepartmentServiceImpl
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
       List<DepartmentDto> departments = departmentService.getAllDepartments();
       return ResponseEntity.ok(departments);
    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,@RequestBody DepartmentDto updatedDepartment){
//        @RequestBody Annotation: In Spring MVC, the @RequestBody annotation is used to bind the content of the HTTP request body to a Java object. In your code,
                DepartmentDto departmentDto = departmentService.updateDepartment(departmentId,updatedDepartment);
        return  ResponseEntity.ok(departmentDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted Successfully");
    }

}
