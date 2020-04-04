package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.UserFocusRelationDao;
import com.quan.pojo.UserFocusRelation;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFocusRelationBiz implements UserFocusRelationSer{
	private UserFocusRelationDao userFocusRelationDao;

	@Autowired
	public void setUserFocusRelationDao(UserFocusRelationDao userFocusRelationDao) {
		this.userFocusRelationDao = userFocusRelationDao;
	}

	@Override
	public List<UserFocusRelation> get() {
		
		List<UserFocusRelation> list = null;
		list = userFocusRelationDao.get();
		return list;
	}

	@Override
	public UserFocusRelation getById(int userFocusRelationId) {
		
		UserFocusRelation userFocusRelation = null;
		userFocusRelation = userFocusRelationDao.getById(userFocusRelationId);
		return userFocusRelation;
	}

	@Override
	public List<UserFocusRelation> getByuserId(int userId){
		
		List<UserFocusRelation> list = null;
		list = userFocusRelationDao.getByuserId(userId);
		return list;
	}
	@Override
	public List<UserFocusRelation> getBytargetUserId(int targetUserId){
		
		List<UserFocusRelation> list = null;
		list = userFocusRelationDao.getBytargetUserId(targetUserId);
		return list;
	}
	@Override
	public UserFocusRelation getByRelation(int userId, int targetUserId) {
		
		UserFocusRelation userFocusRelation = null;
		userFocusRelation = userFocusRelationDao.getByRelation(userId, targetUserId);
		return userFocusRelation;
	}

	@Override
	public void add(UserFocusRelation userFocusRelation) {
		
		userFocusRelationDao.add(userFocusRelation);

	}

	@Override
	public void update(UserFocusRelation userFocusRelation) {
		userFocusRelationDao.update(userFocusRelation);
	}

	@Override
	public void delete(int userFocusRelationId) {
		userFocusRelationDao.delete(userFocusRelationId);
	}
}
