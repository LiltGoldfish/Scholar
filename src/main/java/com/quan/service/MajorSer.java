package com.quan.service;

import com.quan.pojo.Major;

import java.util.List;

public interface MajorSer {
    List<Major> get();
    Major getById(int majorId);
    List<Major> getByDepartmentId(int departmentId);
}
