package com.quan.service;

import com.quan.pojo.Department;

import java.util.List;

public interface DepartmentSer {
    List<Department> get();
    Department getById(int departmentId);
}
