package com.quan.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.quan.dao.LessonDao;
import com.quan.pojo.Lesson;
import com.quan.pojo.PageUtil;
import com.quan.util.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LessonBiz implements LessonSer{
	private LessonDao lessonDao;

	@Autowired
	public void setLessonDao(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
	}

	@Override
	public List<Lesson> get() {

        List<Lesson> list = null;
        list = lessonDao.get();
        return list;
	}

	@Override
	public Lesson getById(int lessonId) {
        Lesson lesson = null;
        lesson = lessonDao.getById(lessonId);
        return lesson;
	}
	
	public List<Lesson> getByTeacherId(int teacherId){

        List<Lesson> list = null;
        list = lessonDao.getByTeacherId(teacherId);
        return list;
	}

	public void add(Lesson lesson) {
		lessonDao.add(lesson);
	}

	public void update(Lesson lesson) {
		lessonDao.update(lesson);
	}

	public void delete(int lessonId) {
		lessonDao.delete(lessonId);
	}

	public PageUtil<Lesson> getSearchLessonPage(String searchString, int pageIndex, int pageSize) {

		PageUtil<Lesson> pageUtilDao = new PageUtil<>();
		pageIndex = (pageIndex < 1) ? 1 : pageIndex;
		pageSize = (pageSize < 1) ? 1 : pageSize;

		pageUtilDao.setIndex(pageIndex);
		pageUtilDao.setPageSize(pageSize);
		searchString = "%" + searchString + "%";
		int totalItem = lessonDao.getSearchLessonTotalItem(searchString);
		pageUtilDao.setTotalItem(totalItem);
		pageUtilDao.setTotalPage((int)Math.ceil((double)totalItem / (double)pageSize));
		pageUtilDao.setList(lessonDao.getSearchLessonPageList(searchString, (pageIndex - 1) * pageSize, pageSize));
		return pageUtilDao;
	}
}
