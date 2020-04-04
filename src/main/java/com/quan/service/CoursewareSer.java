package com.quan.service;

import com.quan.pojo.Courseware;

import java.util.List;

public interface CoursewareSer {
    List<Courseware> getByLessonID(int lessonID);
    boolean add(Courseware courseware);
    boolean update(Courseware courseware);
    boolean deleteById(int id);
}
