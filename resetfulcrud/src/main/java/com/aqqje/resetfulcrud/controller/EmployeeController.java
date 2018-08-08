package com.aqqje.resetfulcrud.controller;

import com.aqqje.resetfulcrud.dao.DepartmentDao;
import com.aqqje.resetfulcrud.dao.EmployeeDao;
import com.aqqje.resetfulcrud.entities.Department;
import com.aqqje.resetfulcrud.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 获取所有员工列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    // 跳转添加员工界面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/add";
    }

    // 添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        // 添加员工
        System.out.println("添加员工" + employee);
        employeeDao.save(employee);
        // 重定向list.html
        return "redirect:/emps";
    }

    // 查出当前 emp id 跳转到add.html
    @GetMapping("/emp/{id}")
    public String toUpdataPage(@PathVariable("id") Integer id, Model model){

        // 根据id查询emp
        Employee employee = employeeDao.get(id);
        // 查出所有部门
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        model.addAttribute("emp", employee);
        return "emp/add";
    }

    // 修改员工
    @PutMapping("/emp")
    public String updataEmp(Employee employee){
        System.out.println("修改员工" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 根据id删除emp
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
