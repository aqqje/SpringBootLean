package com.aqqje.cache.service;

import com.aqqje.cache.bean.Department;
import com.aqqje.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"dept"}, cacheManager = "deptCacheManager" )
public class DepartementService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(key = "#id")
    public Department findById(Integer id){
        return departmentMapper.findById(id);
    }
}
