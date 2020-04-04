package com.quan.dao;


import com.quan.pojo.PageUtil;
import com.quan.pojo.User;

public interface PageUtilDao {
	
	//根据课程给学生列表分页
	public PageUtil<User> pageFind(int pageIndex, int pageSize,int lessonId,int totalItem);
	
}
