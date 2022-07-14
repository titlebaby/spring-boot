package com.example.springboot01.dao;

import com.example.springboot01.pojo.Department;
import com.example.springboot01.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    @Autowired
    private DepartmentDao departmentDao;
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "25262429@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "25262429@qq.com", 0, new Department(101, "教学部")));
        employees.put(1003, new Employee(1003, "CC", "25262429@qq.com", 1, new Department(101, "教学部")));
        employees.put(1004, new Employee(1004, "DD", "25262429@qq.com", 0, new Department(101, "教学部")));
        employees.put(1005, new Employee(1005, "EE", "25262429@qq.com", 1, new Department(101, "教学部")));
    }

    private static  Integer ininId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(ininId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);

    }
}
