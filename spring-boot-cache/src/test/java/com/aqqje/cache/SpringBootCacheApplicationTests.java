package com.aqqje.cache;

import com.aqqje.cache.bean.Department;
import com.aqqje.cache.bean.Employee;
import com.aqqje.cache.mapper.DepartmentMapper;
import com.aqqje.cache.mapper.EmployeeMapper;
import com.aqqje.cache.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象的

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

    @Autowired
    RedisTemplate<Object, Employee> jsonRedisTemplate;

    @Autowired
    RedisTemplate<Object, Department> deptJsonRedisTemplate;

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;
    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @Test
    public void testStringRedisTemplate(){
        // 给redis保存数据
        //stringRedisTemplate.opsForValue().append("msg", "aqqje");
        //String msg = stringRedisTemplate.opsForValue().get("msg");
        //System.out.println(msg);
        //stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
    }

    // 测试保存对象
    @Test
    public void testRedisTemplate(){
        Employee id = employeeService.findById(4);
        //redisTemplate.opsForValue().set("emp-01", id);

        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
        jsonRedisTemplate.opsForValue().set("emp-01", id);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void connection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void crud(){
//        Employee employee = employeeService.findById(1); true
//        boolean flag = employeeService.deleteById(5);
//        Employee employee = new Employee(null, "aaaa", "1840844741@qq.com", 1, 0);
//       boolean flag = employeeService.insertEmp(employee);
//        Employee emp = employeeService.updateById(employee);
//        Employee employee = new Employee(3,"11111111111111111", "100", 1, 2);
//        boolean flag = employeeService.updateById(employee);
//        System.out.println(flag);
        Department dept = departmentMapper.findById(1);
        System.out.println(dept.toString());
    }

    @Test
    public void test1(){
        Cache cache = deptCacheManager.getCache("dept");
        Object nativeCache = cache.getNativeCache();
        System.out.println(cache.getName());
    }

}
