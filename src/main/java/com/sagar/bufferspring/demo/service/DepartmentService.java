package com.sagar.bufferspring.demo.service;

import com.sagar.bufferspring.demo.entity.Department;
import com.sagar.bufferspring.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department updateDepartment(Long departmentId, Department department);

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department fetchDepartmentByName(String departmentName);
}
