package com.aqqje.cache.controller;


import com.aqqje.cache.bean.Employee;
import com.aqqje.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        return employeeService.findById(id);
    }

    @GetMapping("/emp")
    public Employee insertEmp(Employee employee){
        employee = new Employee(null, "aqqje", "1042136232@qq.com ", 1, 1);
        employeeService.insertEmp(employee);
        return employee;
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
