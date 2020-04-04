package com.quan.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.UserDao;
import com.quan.pojo.PageUtil;
import com.quan.pojo.User;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageUtilBiz implements PageUtilSer{
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//根据课程取学生总数
	@Override
	public int getTotalItem(int lessonId){
		return userDao.getTotalItem(lessonId);
	}

	//根据课程分页返回当前页学生列表
	@Override
	public List<User> page(int pageIndex, int pageSize,int lessonId){
		List<User> list = null;
		int truePage=(pageIndex-1)*pageSize;
		list = userDao.page(pageIndex, pageSize, lessonId,truePage);
		return list;
	}
	
	//封装分页
	@Override
	public PageUtil<User> pageFind(int pageIndex, int pageSize,int lessonId,int totalItem){
		PageUtil<User> pageUtil=new PageUtil<User>();
		List<User> list=new ArrayList<User>();
			int truePage=(pageIndex-1)*pageSize;
			list=userDao.page(pageIndex, pageSize,lessonId,truePage);
			//封装分页数据
			pageUtil.setIndex(pageIndex);
			pageUtil.setPageSize(pageSize);
			pageUtil.setTotalPage((int)Math.ceil((double)totalItem/pageSize));//计算总页数
			pageUtil.setTotalItem(totalItem);
			pageUtil.setList(list);

		return pageUtil;
	}
}
