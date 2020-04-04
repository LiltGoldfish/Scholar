package com.quan.service;

import com.quan.pojo.Lesson;
import com.quan.pojo.StudentLessonRelation;

import java.util.List;

public interface StudentLessonRelationSer {
    List<StudentLessonRelation> get();
    StudentLessonRelation getById(int studentLessonRelationId);
    StudentLessonRelation getByRelation(int studentId, int lessonId);
    List<Lesson> getByStudentId(int studentId);
    void add(StudentLessonRelation studentLessonRelation);
    void update(StudentLessonRelation studentLessonRelation);
    void delete(int studentLessonRelationId);
    List<StudentLessonRelation> getByLessonId(int lessonId);
}
