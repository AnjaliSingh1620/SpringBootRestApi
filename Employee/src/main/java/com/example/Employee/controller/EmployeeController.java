package com.example.Employee.controller;

import com.example.Employee.entity.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@Controller //marks this class as controller
@ResponseBody //since we are returning body in get method
//@RestController combines above 2
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/employees")
    public List<Employee> findAllEmployee(){

        return employeeService.getAllEmployee();
    }
    @RequestMapping("/employees/{id}")
    public Employee getAnEmployee(@PathVariable int id){
        return employeeService.getAnEmployee(id);
    }

    @PostMapping(value = "/addEmployee")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployee();
    }

}
