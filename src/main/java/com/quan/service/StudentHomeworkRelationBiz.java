package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.StudentHomeworkRelationDao;
import com.quan.pojo.StudentHomeworkRelation;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentHomeworkRelationBiz implements StudentHomeworkRelationSer{
	private StudentHomeworkRelationDao studentHomeworkRelationDao;

	@Autowired
	public void setStudentHomeworkRelationDao(StudentHomeworkRelationDao studentHomeworkRelationDao) {
		this.studentHomeworkRelationDao = studentHomeworkRelationDao;
	}

	@Override
	public List<StudentHomeworkRelation> get() {
		
		List<StudentHomeworkRelation> list = null;
		list = studentHomeworkRelationDao.get();
		return list;
	}

	@Override
	public StudentHomeworkRelation getById(int studentHomeworkRelationId) {
		
		StudentHomeworkRelation studentHomeworkRelation = null;
		studentHomeworkRelation = studentHomeworkRelationDao.getById(studentHomeworkRelationId);
		return studentHomeworkRelation;
	}

	@Override
	public void add(StudentHomeworkRelation studentHomeworkRelation) {
		studentHomeworkRelationDao.add(studentHomeworkRelation);
	}

	@Override
	public void update(StudentHomeworkRelation studentHomeworkRelation) {
		studentHomeworkRelationDao.update(studentHomeworkRelation);

	}

	@Override
	public void delete(int studentHomeworkRelationId) {
		studentHomeworkRelationDao.delete(studentHomeworkRelationId);

	}
	@Override
	public List<StudentHomeworkRelation> getByHomeworkId(int homeworkId) {
		List<StudentHomeworkRelation> list = null;
		list = studentHomeworkRelationDao.getByHomeworkId(homeworkId);
		return list;
	} 

	@Override
	public List<StudentHomeworkRelation> getByLessonId(int lessonId) {
		
		List<StudentHomeworkRelation> list = null;
		list = studentHomeworkRelationDao.getByLessonId(lessonId);
		return list;
	}
	@Override
	public List<StudentHomeworkRelation> getByTheStudentId(int studentId) {
		
		List<StudentHomeworkRelation> list = null;
		list = studentHomeworkRelationDao.getByTheStudentId(studentId);
		return list;
	} 
	@Override
	public StudentHomeworkRelation getByLessonIdHomeworkId(int studentId, int homeworkId) {
		
		StudentHomeworkRelation studentHomeworkRelation = null;
		studentHomeworkRelation = studentHomeworkRelationDao.getByLessonIdHomeworkId(studentId, homeworkId);
		return studentHomeworkRelation;
	}

	@Override
	public List<StudentHomeworkRelation> getHomeworkByStudentId(int studentId, int lessonId) {
		return studentHomeworkRelationDao.getHomeworkByStudentId(studentId, lessonId);
	}
}
