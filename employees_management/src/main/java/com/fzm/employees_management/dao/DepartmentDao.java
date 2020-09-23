package com.fzm.employees_management.dao;

import com.fzm.employees_management.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(1001,new Department(1001,"人事部"));
        departments.put(1002,new Department(1002,"财务部"));
        departments.put(1003,new Department(1003,"后勤部"));
        departments.put(1004,new Department(1004,"采购部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}

