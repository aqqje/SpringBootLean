package com.aqqje.cache.mapper;

import com.aqqje.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee findById(Integer id);

    @Update("UPDATE employee SET lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} WHERE id = #{id}")
    public int updateById(Employee employee);

    @Delete("DELETE from employee WHERE id = #{id}")
    public int deleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO employee(lastName, email, gender, d_id) VALUES(#{lastName}, #{email}, #{gender}, #{dId})")
    public int insertEmp(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
