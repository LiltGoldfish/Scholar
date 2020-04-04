package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.PrivateMessageDao;
import com.quan.pojo.PrivateMessage;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivateMessageBiz implements  PrivateMessageSer{
	private PrivateMessageDao privateMessageDao;

	@Autowired
	public void setPrivateMessageDao(PrivateMessageDao privateMessageDao) {
		this.privateMessageDao = privateMessageDao;
	}

	@Override
	public List<PrivateMessage> get() {
		
		List<PrivateMessage> list = null;
		list = privateMessageDao.get();
		return list;
	}

	@Override
	public PrivateMessage getById(int privateMessageId) {
		
		PrivateMessage privateMessage = null;
		privateMessage = privateMessageDao.getById(privateMessageId);
		return privateMessage;
	}
	@Override
	public List<PrivateMessage> getByTargetUserId(int privateMessageId) {
		
		List<PrivateMessage> list = null;
		list = privateMessageDao.getByTargetUserId(privateMessageId);
		return list;
	}

	@Override
	public void add(PrivateMessage privateMessage) {
		privateMessageDao.add(privateMessage);
	}

	@Override
	public void update(PrivateMessage privateMessage) {
		privateMessageDao.update(privateMessage);
	}

	@Override
	public void delete(int privateMessageId) {
		privateMessageDao.delete(privateMessageId);
	}
}
