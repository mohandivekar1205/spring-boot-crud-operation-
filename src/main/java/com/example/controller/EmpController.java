package com.example.controller;


import com.example.model.Employee;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {


    @Autowired
    EmpService empService;


    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
       return empService.saveEmployee(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
        return empService.getAllEmployee();
    }

    @GetMapping("/getById/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return empService.getEmployeeById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAllEmployee(@RequestBody Employee employee){
        return empService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(empService.getEmployeeById(id)!=null){
             return empService.deleteEmployee(id);
        }else {
            return "Employee id not found";
        }

    }
}
