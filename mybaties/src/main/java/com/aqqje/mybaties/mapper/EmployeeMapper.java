package com.aqqje.mybaties.mapper;

import com.aqqje.mybaties.beans.Employee;

public interface EmployeeMapper {

    public Employee getById(Integer id);

    public int insertEmp(Employee employee);

}
