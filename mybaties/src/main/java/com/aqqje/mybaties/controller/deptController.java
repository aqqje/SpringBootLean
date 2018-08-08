package com.aqqje.mybaties.controller;

import com.aqqje.mybaties.beans.Department;
import com.aqqje.mybaties.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class deptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department selectDeptById(@PathVariable("id") Integer id){
        return departmentMapper.selectDepartmentById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDepartment(department);
        return department;
    }
}
