package com.example.service;


import com.example.exception.EmployeeAlreadyExist;
import com.example.exception.InvalidMailAddressField;
import com.example.exception.InvalidMobileNumberField;
import com.example.exception.InvalidSalaryField;
import com.example.model.Employee;
import com.example.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    public EmpRepository empRepository;

    public ResponseEntity<String> saveEmployee(Employee employee) {
        if(getEmployeeByMobile(employee.getMobile()) || getEmployeeByEmail(employee.getEmail())){
            return ResponseEntity.ok(String.valueOf( new EmployeeAlreadyExist("Employee Already Exist")));
        }else{
            if(saveEmployee(employee)!=null){
                return ResponseEntity.ok("Employee Inserted Successfully");
            }else {
                return ResponseEntity.ok("Something went wrong! Please try again");
            }
        }
    }

    public List<Employee> getAllEmployee() {
        return empRepository.findAll();
    }

    public ResponseEntity<String> updateEmployee(Employee employee) {

        if (!getEmployeeByEmail(employee.getEmail())){
            employee.setEmail(employee.getEmail());
        }else {
            return ResponseEntity.ok(String.valueOf(new InvalidMailAddressField("Email Already Exist! Try Another one")));

        }


        if (!getEmployeeByMobile(employee.getMobile())) {
            employee.setMobile(employee.getMobile());
        } else {
            return ResponseEntity.ok(String.valueOf(new InvalidMobileNumberField("Mobile Number Already Exist! Try Another one")));

        }


        try{
            if (employee.getSalary() < 0){
                return ResponseEntity.ok("Salary Should Be Greater Than 0");
            }
        }catch (InvalidSalaryField e){
            return ResponseEntity.ok(e.getMessage());
        }

        if(empRepository.save(employee)!=null){
            return ResponseEntity.ok("Record Updated Successfully");
        }else {
            return ResponseEntity.ok("Something went Wrong ");
        }
    }

    public Employee getEmployeeById(int id){
        return empRepository.findById(id).orElse(null);
    }

    public boolean getEmployeeByMobile(long number){

        if(empRepository.findByNumber((number))!=null){
            return true;
        }else {
            return false;
        }
    }


    public boolean getEmployeeByEmail(String mail){
        try{
            if(empRepository.findByMailAddress(mail)!=null){
                return true;
            }else {
                return false;
            }
        }catch (NullPointerException exception){
             exception.getMessage();
             return false;
        }
    }
    public String deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        empRepository.delete(employee);
        return "employee deleted";
    }
}
