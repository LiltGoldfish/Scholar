package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.HomeworkDao;
import com.quan.pojo.Homework;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkBiz implements HomeworkSer{
	private HomeworkDao homeworkDao;

	@Autowired
	public void setHomeworkDao(HomeworkDao homeworkDao) {
		this.homeworkDao = homeworkDao;
	}

	@Override
	public List<Homework> get() {

		List<Homework> list = null;
		list = homeworkDao.get();
		return list;
	}

	@Override
	public Homework getById(int homeworkId) {

		Homework homework = null;
		homework = homeworkDao.getById(homeworkId);
		return homework;
	}

	public void add(Homework homework) {
		homeworkDao.add(homework);
	}

	public void update(Homework homework) {
		homeworkDao.update(homework);
	}

	public void delete(int homeworkId) {
		homeworkDao.delete(homeworkId);
	}
	
	public List<Homework> getByLessonId(int lessonId) {
		List<Homework> list = null;
		list = homeworkDao.getByLessonId(lessonId);
		return list;
	}
	
	public List<Homework> getByLessonIdNot(int studentId, int lessonId) {
		List<Homework> list = null;
		list = homeworkDao.getByLessonIdNot(studentId, lessonId);
		return list;
	}
}
