package com.quan.service;

import com.quan.pojo.Homework;

import java.util.List;

public interface HomeworkSer {
    List<Homework> get();
    Homework getById(int homeworkId);
}
