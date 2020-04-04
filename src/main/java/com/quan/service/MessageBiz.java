package com.quan.service;

import java.util.ArrayList;
import java.util.List;

import com.quan.pojo.PrivateMessage;
import org.apache.ibatis.session.SqlSession;

import com.quan.dao.MessageDao;
import com.quan.pojo.Message;
import com.quan.util.MessageUtil;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageBiz implements MessageSer{
	private MessageDao messageDao;

	@Autowired
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public List<Message> get() {

		List<Message> list = null;
		list = messageDao.get();
		return list;
	}

	@Override
	public Message getById(int MessageId) {

		Message message = null;
		message = messageDao.getById(MessageId);
		return message;
	}
	@Override
	public List<Message> getByParentMessageId(int parentMessageId) {
		List<Message> list = null;
		list = messageDao.getByParentMessageId(parentMessageId);
		return list;
	}

	@Override
	public void add(Message Message) {
		messageDao.add(Message);
	}

	@Override
	public void update(Message Message) {
		messageDao.update(Message);
	}

	@Override
	public void delete(int MessageId) {
		messageDao.delete(MessageId);
	}

	@Override
	public List<MessageUtil> getByLessonId(int lessonId) {

		List<MessageUtil> utilList = new ArrayList<MessageUtil>();

		List<Message> floorHostList = messageDao.getFloorHostByLessonId(lessonId);
		for (Message message : floorHostList) {
			MessageUtil util = new MessageUtil();
			util.setMessage(message);
			util.setReplyList(messageDao.getFloorReplyByLessonId(lessonId, message.getFloor()));
			utilList.add(util);
		}

		return utilList;
	}
}
