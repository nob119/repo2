package com.fzm.employees_management.dao;

import com.fzm.employees_management.pojo.Department;
import com.fzm.employees_management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(2001,new Employee(2001,"张三",1,"123456@qq.com", new Department(1001,"人事部")));
        employees.put(2002,new Employee(2002,"李四",0,"123456@qq.com", new Department(1002,"财务部")));
        employees.put(2003,new Employee(2003,"刘洋",1,"123456@qq.com", new Department(1003,"后勤部")));
        employees.put(2004,new Employee(2004,"王昊",0,"123456@qq.com", new Department(1004,"采购部")));
        employees.put(2005,new Employee(2005,"程红",1,"123456@qq.com", new Department(1002,"财务部")));
        employees.put(2006,new Employee(2006,"赵武",0,"123456@qq.com", new Department(1003,"后勤部")));
    }

    private static Integer initId = 2007;

    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    public void addEmployee(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    public Employee getEmployee(Integer id){
        return employees.get(id);
    }

    public void delEmployee(Integer id){
        employees.remove(id);
    }
}
