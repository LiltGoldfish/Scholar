package com.quan.service;

import com.quan.dao.CoursewareDao;
import com.quan.pojo.Courseware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursewareBiz implements CoursewareSer {

    CoursewareDao coursewareDao;

    @Autowired
    public void setCoursewareDao(CoursewareDao coursewareDao) {
        this.coursewareDao = coursewareDao;
    }

    @Override
    public List<Courseware> getByLessonID(int lessonID) {
        return coursewareDao.getByLessonID(lessonID);
    }

    @Override
    public boolean add(Courseware courseware) {
        return coursewareDao.add(courseware);
    }

    @Override
    public boolean update(Courseware courseware) {
        return coursewareDao.update(courseware);
    }

    @Override
    public boolean deleteById(int id) {
        return coursewareDao.deleteById(id);
    }
}
