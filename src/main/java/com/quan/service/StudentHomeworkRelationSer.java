package com.quan.service;

import com.quan.pojo.StudentHomeworkRelation;

import java.util.List;

public interface StudentHomeworkRelationSer {
    List<StudentHomeworkRelation> get();
    StudentHomeworkRelation getById(int studentHomeworkRelationId);
    void add(StudentHomeworkRelation studentHomeworkRelation);
    void update(StudentHomeworkRelation studentHomeworkRelation);
    void delete(int studentHomeworkRelationId);
    List<StudentHomeworkRelation> getByHomeworkId(int homeworkId);
    List<StudentHomeworkRelation> getByLessonId(int lessonId);
    List<StudentHomeworkRelation> getByTheStudentId(int studentId);
    StudentHomeworkRelation getByLessonIdHomeworkId(int studentId, int homeworkId);
    List<StudentHomeworkRelation> getHomeworkByStudentId(int studentId , int lessonId);

}
