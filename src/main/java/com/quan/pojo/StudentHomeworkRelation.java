package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 实体类,学生与作业关系类,用于记录和关联学生提交的作业
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentHomeworkRelation {
	
	private int studentHomeworkRelationId;
	private User student;
	private Homework homework;
	private Date submitTime;
	private int score;
	private String src;
}
