package com.fzm.employees_management.controller;

import com.fzm.employees_management.dao.DepartmentDao;
import com.fzm.employees_management.dao.EmployeeDao;
import com.fzm.employees_management.pojo.Department;
import com.fzm.employees_management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/all")
    public String getEmployees(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees",employees);
        return "employee/list";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "employee/add";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.addEmployee(employee);
        return "redirect:/emp/all";
    }

    @RequestMapping("/del")
    public String delEmployee(@RequestParam("id") Integer id){
        employeeDao.delEmployee(id);
        return "redirect:/emp/all";
    }

    @GetMapping("/update")
    public String showEmployee(@RequestParam("id") Integer id,Model model){
        Employee employee = employeeDao.getEmployee(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "employee/update";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/emp/all";
    }
}
