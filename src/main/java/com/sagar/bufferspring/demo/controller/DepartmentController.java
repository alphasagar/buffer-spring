package com.sagar.bufferspring.demo.controller;

import com.sagar.bufferspring.demo.entity.Department;
import com.sagar.bufferspring.demo.error.DepartmentNotFoundException;
import com.sagar.bufferspring.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){

        LOGGER.info("at savedept");
            return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){

        LOGGER.info("inside fetch");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public  String deleteDepartmentById(@PathVariable("id") Long departmentId){

        departmentService.deleteDepartmentById(departmentId);
        return "deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){

        return departmentService.updateDepartment(departmentId,department);

    }

    @GetMapping("/departments/name/{name}")
    public  Department fetchDepartmentByName(@PathVariable("name") String departmentName){
            return departmentService.fetchDepartmentByName(departmentName);
    }

}
