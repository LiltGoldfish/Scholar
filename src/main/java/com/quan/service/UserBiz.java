package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.UserDao;
import com.quan.pojo.PageUtil;
import com.quan.pojo.User;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBiz implements UserSer{
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> get() {
		
		List<User> list = null;
		list = userDao.get();
		return list;
	}

	@Override
	public User getById(int userId) {
		
		User user = null;
		user = userDao.getById(userId);
		return user;
	}

	@Override
	public User getByUserUsername(String userUsername) {
		
		User user = null;
		user = userDao.getByUserUsername(userUsername);
		return user;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void update(User user) {

		userDao.update(user);

	}

	@Override
	public void delete(int userId) {
		
		userDao.delete(userId);

	}
	@Override
	public PageUtil<User> getSearchUserPage(String searchString, int pageIndex, int pageSize) {


		PageUtil<User> userPage = new PageUtil<User>();
		userPage.setIndex(pageIndex);
		userPage.setPageSize(pageSize);
			
			searchString = "%" + searchString + "%";
			int totalItem = userDao.getSearchLessonTotalItem(searchString);
			userPage.setTotalItem(totalItem);
			userPage.setTotalPage((int)Math.ceil((double)totalItem / (double)pageSize));
			userPage.setList(userDao.getSearchLessonPageList(searchString, (pageIndex - 1) * pageSize, pageSize));

		return userPage;
	}
}
