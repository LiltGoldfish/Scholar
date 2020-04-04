package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.StudentLessonRelationDao;
import com.quan.pojo.Lesson;
import com.quan.pojo.StudentLessonRelation;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLessonRelationBiz implements StudentLessonRelationSer{
	private StudentLessonRelationDao studentLessonRelationDao;

	@Autowired
	public void setStudentLessonRelationDao(StudentLessonRelationDao studentLessonRelationDao) {
		this.studentLessonRelationDao = studentLessonRelationDao;
	}

	@Override
	public List<StudentLessonRelation> get() {
		List<StudentLessonRelation> list = null;
		list = studentLessonRelationDao.get();
		return list;
	}

	@Override
	public StudentLessonRelation getById(int studentLessonRelationId) {
		StudentLessonRelation studentLessonRelation = null;
		studentLessonRelation = studentLessonRelationDao.getById(studentLessonRelationId);
		return studentLessonRelation;
	}
	@Override
	public StudentLessonRelation getByRelation(int studentId, int lessonId) {
		StudentLessonRelation studentLessonRelation = null;
		studentLessonRelation = studentLessonRelationDao.getByRelation(studentId, lessonId);
		return studentLessonRelation;
	}
	@Override
	public List<Lesson> getByStudentId(int studentId){
		
		List<Lesson> list = null;
		list = studentLessonRelationDao.getByStudentId(studentId);
		return list;
	}

	@Override
	public void add(StudentLessonRelation studentLessonRelation) {
		studentLessonRelationDao.add(studentLessonRelation);
	}
	@Override
	public void update(StudentLessonRelation studentLessonRelation) {
		
		studentLessonRelationDao.update(studentLessonRelation);

	}

	@Override
	public void delete(int studentLessonRelationId) {
		
		studentLessonRelationDao.delete(studentLessonRelationId);

	}
	@Override
	public List<StudentLessonRelation> getByLessonId(int lessonId) {

		List<StudentLessonRelation> list = null;
		list = studentLessonRelationDao.getByLessonId(lessonId);
		return list;
	}
}
