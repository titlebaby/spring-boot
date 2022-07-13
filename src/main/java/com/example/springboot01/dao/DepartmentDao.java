package com.example.springboot01.dao;

import com.example.springboot01.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //   模拟数据路
    //  初始化的时候就加载

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(105, "市场部"));
        departments.put(103, new Department(105, "教研部"));
        departments.put(104, new Department(105, "运营部"));
        departments.put(105, new Department(105, "测试部"));
    }

    public Collection<Department> getDepartment() {
        return departments.values();
    }

    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
