package com.aqqje.mybaties.mapper;

import com.aqqje.mybaties.beans.Department;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface DepartmentMapper {

    @Options
    @Select("select * from department where id = #{id}")
    public Department selectDepartmentById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys =true, keyProperty="id")
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDepartmentByName(Department department);

    @Options(useGeneratedKeys =true, keyProperty="id")
    @Insert("insert into department (departmentName) values (#{departmentName}) ")
    public int insertDepartment(Department department);
}
