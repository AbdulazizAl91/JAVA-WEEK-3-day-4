package com.example.employeesmanagement.Controller;

import com.example.employeesmanagement.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/employee")

public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Employee> getEmployees(){
        return employees;
    }
    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body("employee add");
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index,@RequestBody @Valid Employee employee, Errors errors){
    if (errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    employees.set(index,employee);
    return ResponseEntity.status(200).body("employee updated");
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index){
        if (employees.size()==0){
            return ResponseEntity.status(400).body("array is empty");
        }
        employees.remove(index);
        return ResponseEntity.status(200).body("employee deleted");
    }
    @PutMapping("/annual/{index}")
    public ResponseEntity putannual(@PathVariable int index,@RequestBody @Valid Employee employee,Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        else if (employees.get(index).getAnnualLeave()==0){
            return ResponseEntity.status(400).body("employee  annual leave ==0");
        }
        boolean onLevel = true;
        int annul = employee.getAnnualLeave() -1;
        employee.setAnnualLeave(annul);
        employee.setOnLeave(onLevel);
        employees.set(index,employee);
        return ResponseEntity.status(200).body("employee is on level");

    }




}
