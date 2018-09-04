package com.aqqje.cache.mapper;

import com.aqqje.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    public Department findById(Integer id);
}
