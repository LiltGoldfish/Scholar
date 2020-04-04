package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.MajorDao;
import com.quan.pojo.Major;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorBiz implements MajorSer{
	private MajorDao majorDao;

	@Autowired
	public void setMajorDao(MajorDao majorDao) {
		this.majorDao = majorDao;
	}

	@Override
	public List<Major> get() {

		List<Major> list = null;
		list = majorDao.get();
		return list;
	}

	@Override
	public Major getById(int majorId) {

		Major major = null;
		major = majorDao.getById(majorId);
		return major;
	}
	@Override
	public List<Major> getByDepartmentId(int departmentId){

		List<Major> list = null;
		list = majorDao.getByDepartmentId(departmentId);
		return list;
	}
}
