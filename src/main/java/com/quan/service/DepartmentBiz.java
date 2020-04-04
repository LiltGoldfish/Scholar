package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.DepartmentDao;
import com.quan.pojo.Department;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentBiz implements DepartmentSer{
	private DepartmentDao departmentDao;

	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> get() {
		List<Department> list = null;
		list = departmentDao.get();
		return list;
	}

	@Override
	public Department getById(int departmentId) {

		Department department = null;
		department = departmentDao.getById(departmentId);
		return department;
	}
}
