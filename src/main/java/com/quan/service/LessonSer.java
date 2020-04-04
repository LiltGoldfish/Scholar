package com.quan.service;

import com.quan.pojo.Lesson;

import java.util.List;

public interface LessonSer {
    List<Lesson> get();
    Lesson getById(int lessonId);
}
